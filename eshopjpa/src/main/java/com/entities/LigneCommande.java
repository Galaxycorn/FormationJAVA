package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "LigneCommande")
public class LigneCommande {

    @EmbeddedId
    private LigneCommandeId ligneCommandeId;

    @Column(name = "ligne_quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public LigneCommande() {
    }

    public LigneCommande(LigneCommandeId ligneCommandeId, int quantite) {
        this.ligneCommandeId = ligneCommandeId;
        this.quantite = quantite;
    }

    public LigneCommandeId getId() {
        return this.ligneCommandeId;
    }

    public void setId(LigneCommandeId ligneCommandeId) {
        this.ligneCommandeId = ligneCommandeId;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return this.commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return this.produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LigneCommande)) {
            return false;
        }
        LigneCommande ligneCommande = (LigneCommande) o;
        return Objects.equals(ligneCommandeId, ligneCommande.ligneCommandeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ligneCommandeId);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", quantite='" + getQuantite() + "'" +
                "}";
    }

}
