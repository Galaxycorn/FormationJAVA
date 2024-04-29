package com.eshopJPASpringBoot.demo.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class Client extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    int id;

    @Column(name = "client_prenom")
    String prenom;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    public Client() {

    }

    public Client(String prenom, String nom, String telephone, String mail, List<Commande> commandes, Adresse adresse) {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.mail = mail;
        this.commandes = commandes;
        this.adresse = adresse;
    }

    public Client(String prenom, String nom, String telephone, String mail, Adresse adresse) {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.mail = mail;
        this.adresse = adresse;
    }

    public Client(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Commande> getCommandes() {
        return this.commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", prenom='" + getPrenom() + "'" +
                ", nom='" + getNom() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}