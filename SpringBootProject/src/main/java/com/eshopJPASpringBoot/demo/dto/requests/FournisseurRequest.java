package com.eshopJPASpringBoot.demo.dto.requests;

import java.util.List;

import com.eshopJPASpringBoot.demo.entities.Adresse;
import com.eshopJPASpringBoot.demo.entities.Produit;

public class FournisseurRequest {

    private int id;
    private String nomFournisseur;
    private List<Produit> produits;
    private Adresse adresse;

    public FournisseurRequest() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFournisseur() {
        return this.nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
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

}
