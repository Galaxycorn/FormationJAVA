package com.eshopJPASpringBoot.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_numero")
    private Long numero;

    @Column(name = "produit_nom")
    private String nom;

    @Column(name = "produit_prix")
    private double prix;

    @Column(name = "produit_description")
    private String description;

    @Column(name = "produit_photo")
    private String photo;

    @OneToMany(mappedBy = "produit")
    private Set<LigneCommande> ligneCommandes;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "categorie_code")
    private Categorie categorie;

    public Produit() {
    }

    public Produit(Long numero, String nom, double prix) {
        this.numero = numero;
        this.nom = nom;
        this.prix = prix;
    }
    

    public Produit(String nom, double prix, String description) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
	}

	public Produit(String nom, double prix, String description, String photo, Fournisseur fournisseur,
			Categorie categorie) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.photo = photo;
		this.fournisseur = fournisseur;
		this.categorie = categorie;
	}

	public Long getNumero() {
        return this.numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<LigneCommande> getLigneCommande() {
        return this.ligneCommandes;
    }

    public void setLigneCommande(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produit)) {
            return false;
        }
        Produit produit = (Produit) o;
        return numero == produit.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "{" +
                " numero='" + getNumero() + "'" +
                ", nom='" + getNom() + "'" +
                ", prix='" + getPrix() + "'" +
                "}";
    }

}
