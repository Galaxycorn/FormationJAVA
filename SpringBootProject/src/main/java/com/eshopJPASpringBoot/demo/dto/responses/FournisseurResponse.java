package com.eshopJPASpringBoot.demo.dto.responses;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.eshopJPASpringBoot.demo.entities.Adresse;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

public class FournisseurResponse {

    @JsonView({ JsonViews.Basic.class, JsonViews.FournisseurAvecProduits.class })
    private int id;
    @JsonView({ JsonViews.Basic.class })
    private String nomFournisseur;
    @JsonView({ JsonViews.Basic.class })
    private List<ProduitResponse> produits;
    @JsonView({ JsonViews.Basic.class })
    private Adresse adresse;
    @JsonView({ JsonViews.Basic.class })
    private String mail;
    @JsonView({ JsonViews.Basic.class })
    private String nom;
    @JsonView({ JsonViews.Basic.class })
    private String telephone;

    public FournisseurResponse() {

    }

    public FournisseurResponse(Fournisseur fournisseur) {
        BeanUtils.copyProperties(fournisseur, this);

    }

    public FournisseurResponse(Fournisseur fournisseur, boolean choix) {
        BeanUtils.copyProperties(fournisseur, this);
        if (choix && !fournisseur.getProduits().isEmpty()) {
            produits = fournisseur.getProduits().stream().map(produit -> new ProduitResponse(produit, false))
                    .collect(Collectors.toList());

        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNomFournisseur() {
        return this.nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public List<ProduitResponse> getProduits() {
        return this.produits;
    }

    public void setProduits(List<ProduitResponse> produits) {
        this.produits = produits;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
