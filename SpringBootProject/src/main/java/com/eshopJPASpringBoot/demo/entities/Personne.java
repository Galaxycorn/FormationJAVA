package com.eshopJPASpringBoot.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Personne")
public class Personne {

    @Id
    @Column(name = "personne_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "personne_nom")
    private String nom;

    @Column(name = "personne_mail")
    private String mail;

    @Column(name = "personne_telephone")
    private String telephone;

    public Personne(String nom, String mail, String telephone) {
        this.nom = nom;
        this.mail = mail;
        this.telephone = telephone;
    }
    public Personne(){
        
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Personne)) {
            return false;
        }
        Personne personne = (Personne) o;
        return id == personne.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
