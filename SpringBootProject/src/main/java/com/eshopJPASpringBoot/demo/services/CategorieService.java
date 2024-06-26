package com.eshopJPASpringBoot.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Categorie;
import com.eshopJPASpringBoot.demo.exceptions.CategorieException;
import com.eshopJPASpringBoot.demo.exceptions.NotFoundException;
import com.eshopJPASpringBoot.demo.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.demo.repositories.DaoCategorie;

@Service
public class CategorieService {
    @Autowired
    private DaoCategorie daoCategorie;
    private Logger logger = LoggerFactory.getLogger(CategorieService.class);

    public CategorieService() {
        logger.trace("création du CategorieService: " + this);
    }

    // → création d'une catégorie
    public Categorie creationCategorie(String nom) {
        logger.trace("creation d'une categorie avec un nom");
        return creationCategorie(new Categorie(nom));
    }

    public Categorie creationCategorie(Categorie categorie) {
        logger.trace("creation d'une categorie avec une Categorie");
        if (categorie == null) {
            logger.error("categorie null");
            throw new ReferenceNullException("reference null");
        }
        if (categorie.getNom() == null || categorie.getNom().isBlank()) {
            logger.debug("nom categorie vide");
            throw new CategorieException("nom categorie obligatoire");
        }
        logger.debug(categorie.getNom());
        return daoCategorie.save(categorie);
    }

    // → suppression
    public void delete(Long code) {
        if (code == null) {
            throw new ReferenceNullException();
        }
        Optional<Categorie> categorieSuprimer = daoCategorie.findById(code.intValue());
        logger.debug("suprression de " + categorieSuprimer.hashCode());
        daoCategorie.deleteById(code.intValue());
    }

    // → Recherche de toutes les catégories, id
    public Categorie findById(Long id) {
        return daoCategorie.findById(id.intValue()).orElseThrow(() -> {
            throw new NotFoundException("categorie avec l'id  " + id + " inexistant");
        });
    }

    public List<Categorie> getAll() {
        return daoCategorie.findAll();
    }

}
