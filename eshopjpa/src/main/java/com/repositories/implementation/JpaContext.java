package com.repositories.implementation;

import com.repositories.interfaces.DaoAdresse;
import com.repositories.interfaces.DaoCategorie;
import com.repositories.interfaces.DaoClient;
import com.repositories.interfaces.DaoCommande;
import com.repositories.interfaces.DaoFournisseur;
import com.repositories.interfaces.DaoLigneCommande;
import com.repositories.interfaces.DaoPersonne;
import com.repositories.interfaces.DaoProduit;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaContext {

    // class qui gère l'EntityManagerFactory
    private static EntityManagerFactory singleton = null;
    private static DaoCategorie daoCategorie = null;
    private static DaoClient daoClient = null;
    private static DaoProduit daoProduit = null;
    private static DaoPersonne daoPersonne = null;
    private static DaoAdresse daoAdresse = null;
    private static DaoCommande daoCommande = null;
    private static DaoFournisseur daoFournisseur = null;
    private static DaoLigneCommande daoLigneCommande = null;

    // création sous la forme d'un object unique
    public static EntityManagerFactory getEntityManagerFactory() {
        if (singleton == null) {
            singleton = Persistence.createEntityManagerFactory("beaverLover");
        }
        return singleton;
    }

    public static DaoCategorie getDaoCategorie() {
        if (daoCategorie == null) {
            daoCategorie = new DaoCategorieImpl();
        }
        return daoCategorie;
    }

    public static DaoClient getDaoClient() {
        if (daoClient == null) {
            daoClient = new DaoClientImpl();
        }
        return daoClient;
    }

    public static DaoProduit getDaoProduit() {
        if (daoProduit == null) {
            daoProduit = new DaoProduitImpl();
        }
        return daoProduit;
    }

    public static DaoPersonne getDaoPersonne() {
        if (daoPersonne == null) {
            daoPersonne = new DaoPersonneImpl();
        }
        return daoPersonne;
    }

    public static DaoAdresse getDaoAdresse() {
        if (daoAdresse == null) {
            daoAdresse = new DaoAdresseImpl();
        }
        return daoAdresse;
    }

    public static DaoCommande getDaoCommande() {
        if (daoCommande == null) {
            daoCommande = new DaoCommandeImpl();
        }
        return daoCommande;
    }

    public static DaoFournisseur getDaoFournisseur() {
        if (daoFournisseur == null) {
            daoFournisseur = new DaoFournisseurImpl();
        }
        return daoFournisseur;
    }

    public static DaoLigneCommande getLigneCommande() {
        if (daoLigneCommande == null) {
            daoLigneCommande = new DaoLigneCommandeImpl();
        }
        return daoLigneCommande;
    }

}