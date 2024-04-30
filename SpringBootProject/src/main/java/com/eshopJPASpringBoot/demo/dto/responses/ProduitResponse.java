package com.eshopJPASpringBoot.demo.dto.responses;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.eshopJPASpringBoot.demo.entities.Categorie;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.entities.LigneCommande;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

public class ProduitResponse {

    @JsonView({ JsonViews.Basic.class })
    private Long numero;
    @JsonView({ JsonViews.Basic.class })
    private String nom;
    @JsonView({ JsonViews.Basic.class })
    private double prix;
    @JsonView({ JsonViews.Basic.class })
    private String description;
    private String photo;
    private Set<LigneCommande> ligneCommandes;
    @JsonView({ JsonViews.Basic.class })
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private FournisseurResponse fournisseur;
    private Categorie categorie;

    public ProduitResponse() {

    }

    public ProduitResponse(Produit produit) {
        BeanUtils.copyProperties(produit, this);
        if (produit.getFournisseur() != null) {
            fournisseur = new FournisseurResponse(produit.getFournisseur());
        }
    }

    public ProduitResponse(Produit produit, boolean includeFournisseur) {
        BeanUtils.copyProperties(produit, this);
        if (includeFournisseur) {
            this.fournisseur = new FournisseurResponse(produit.getFournisseur(), false);
        }
    }

    public ProduitResponse(List<Produit> allProduits) {
        BeanUtils.copyProperties(allProduits, this);
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

    public Set<LigneCommande> getLigneCommandes() {
        return this.ligneCommandes;
    }

    public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public FournisseurResponse getFournisseur() {
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurResponse fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

}
