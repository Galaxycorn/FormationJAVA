package com.eshopJPASpringBoot.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresse_id")
    private Long id;

    @Column(name = "adresse_numero")
    private String numero;

    @Column(name = "adresse_rue")
    private String rue;

    @Column(name = "adresse_code_postal")
    private String codePostal;

    @Column(name = "adresse_ville")
    private String ville;

    public Adresse() {
    }

    public Adresse(String numero, String rue, String codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return this.rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Adresse)) {
            return false;
        }
        Adresse adresse = (Adresse) o;
        return Objects.equals(id, adresse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", numero='" + getNumero() + "'" +
                ", rue='" + getRue() + "'" +
                ", codePostal='" + getCodePostal() + "'" +
                ", ville='" + getVille() + "'" +
                "}";
    }

}
