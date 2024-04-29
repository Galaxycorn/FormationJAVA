package com.eshopJPASpringBoot.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Fournisseur")
public class Fournisseur extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fournisseur_id")
    private Integer id;

    @Column(name = "founisseur_nom")
    private String nomFournisseur;

    @OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
    private List<Produit> produits;

    @OneToOne()
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    public Fournisseur() {
    }

    public Fournisseur(String nomFournisseur, List<Produit> produits, Adresse adresse) {
        this.nomFournisseur = nomFournisseur;
        this.produits = produits;
        this.adresse = adresse;
    }

    public Integer getFournisseurId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomFournisseur() {
        return this.nomFournisseur;
    }

    public void setNomFournisseur(String nom) {
        this.nomFournisseur = nom;
    }

    public List<Produit> getProduits() {
        return this.produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fournisseur)) {
            return false;
        }
        Fournisseur fournisseur = (Fournisseur) o;
        return Objects.equals(id, fournisseur.id) && Objects.equals(nomFournisseur, fournisseur.nomFournisseur)
                && Objects.equals(produits, fournisseur.produits)
                && Objects.equals(adresse, fournisseur.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomFournisseur, produits, adresse);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getFournisseurId() + "'" +
                ", nom='" + getNom() + "'" +
                ", produits='" + getProduits() + "'" +
                ", adresse='" + getAdresse() + "'" +
                "}";
    }

}
