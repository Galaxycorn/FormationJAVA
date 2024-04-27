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
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fournisseur_id")
    private Long id;

    @Column(name = "founisseur_nom")
    private String nom;

    @OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
    private List<Produit> produits;

    @OneToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @OneToOne()
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    public Fournisseur() {
    }

    public Fournisseur(String nom, List<Produit> produits, Personne personne, Adresse adresse) {
        this.nom = nom;
        this.produits = produits;
        this.personne = personne;
        this.adresse = adresse;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Produit> getProduits() {
        return this.produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Personne getPersonne() {
        return this.personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
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
        return Objects.equals(id, fournisseur.id) && Objects.equals(
                nom, fournisseur.nom)
                && Objects.equals(produits, fournisseur.produits) && Objects.equals(personne, fournisseur.personne)
                && Objects.equals(adresse, fournisseur.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, produits, personne, adresse);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nom='" + getNom() + "'" +
                ", produits='" + getProduits() + "'" +
                ", personne='" + getPersonne() + "'" +
                ", adresse='" + getAdresse() + "'" +
                "}";
    }

}
