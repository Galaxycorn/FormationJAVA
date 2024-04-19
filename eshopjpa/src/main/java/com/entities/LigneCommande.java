package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "LigneCommande")
public class LigneCommande {

    @Id
    @Column(name = "ligne_commande_id")
    private Long id;

    @Column(name = "ligne_quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    public LigneCommande() {
    }

    public LigneCommande(Long id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LigneCommande)) {
            return false;
        }
        LigneCommande ligneCommande = (LigneCommande) o;
        return Objects.equals(id, ligneCommande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", quantite='" + getQuantite() + "'" +
                "}";
    }

}
