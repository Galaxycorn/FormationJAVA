package com.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "Catégorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorie_code")
    private Long id;

    @Column(name = "categorie_nom", nullable = false, length = 100)
    String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Categorie parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Categorie> children;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private Set<Produit> produits;

    public Categorie() {
    }

    public Categorie(Long id, String nom) {
        this.id = id;
        this.nom = nom;
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

    public Categorie getParent() {
        return this.parent;
    }

    public void setParent(Categorie parent) {
        this.parent = parent;
    }

    public Set<Categorie> getChildren() {
        return this.children;
    }

    public void setChildren(Set<Categorie> children) {
        this.children = children;
    }

    public Set<Produit> getProduits() {
        return this.produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Categorie)) {
            return false;
        }
        Categorie categorie = (Categorie) o;
        return id == categorie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nom='" + getNom() + "'" +
                "}";
    }

}
