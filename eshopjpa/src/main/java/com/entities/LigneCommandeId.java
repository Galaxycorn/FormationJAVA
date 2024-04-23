package com.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class LigneCommandeId {

    @ManyToOne
    @JoinColumn(name = "ligne_commande_id", foreignKey = @ForeignKey(name = "ligne_commande_id_fk"))
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "ligne_produit_id", foreignKey = @ForeignKey(name = "ligne_produit_id_fk"))
    private Produit produit;

    public LigneCommandeId() {

    }

    public LigneCommandeId(Commande commande, Produit produit) {
        this.commande = commande;
        this.produit = produit;
    }

    public Commande getLigneCommande() {
        return this.commande;
    }

    public void setLigneCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getLigneProduit() {
        return this.produit;
    }

    public void setLigneProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LigneCommandeId)) {
            return false;
        }
        LigneCommandeId ligneCommandeId = (LigneCommandeId) o;
        return Objects.equals(commande, ligneCommandeId.commande) && Objects.equals(produit, ligneCommandeId.produit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commande, produit);
    }
}
