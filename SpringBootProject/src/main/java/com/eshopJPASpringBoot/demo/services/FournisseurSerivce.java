package com.eshopJPASpringBoot.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Adresse;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.entities.Personne;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.repositories.DaoFournisseur;
import com.eshopJPASpringBoot.exceptions.FournisseurException;
import com.eshopJPASpringBoot.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.exceptions.NotFoundException;

@Service
public class FournisseurSerivce {

    @Autowired
    private DaoFournisseur daoFournisseur;

    private Logger logger = LoggerFactory.getLogger(FournisseurSerivce.class);

    public FournisseurSerivce() {
        logger.trace("création du FournisseurService: " + this);
    }

    // → creation
    public Fournisseur creationFournisseur(String nom, List<Produit> produits, Personne personne, Adresse adresse) {
        logger.trace("création fournisseur avec tout ses attributs");
        return creationFournisseur(new Fournisseur(nom, produits, personne, adresse));
    }

    public Fournisseur creationFournisseur(Fournisseur fournisseur) {
        logger.trace("creation fournisseur avec Fournisseur");
        if (fournisseur == null) {
            logger.error("fournisseur null");
            throw new ReferenceNullException("reference null");
        }
        if (fournisseur.getNom() == null || fournisseur.getNom().isBlank()) {
            logger.debug("nom vide");
            // probleme=>RunTimeException
            throw new FournisseurException("nom fournisseur obligatoire");
        }
        logger.debug(fournisseur.getNom());

        return daoFournisseur.save(fournisseur);
    }
    // → maj
    public void updateFournisseur(Fournisseur fournisseur) {
        if (fournisseur == null) {
            throw new ReferenceNullException();
        }
        daoFournisseur.findById(fournisseur.getId().intValue()).ifPresent(fournisseurUpdated -> {
            fournisseurUpdated.setAdresse(fournisseur.getAdresse());
            fournisseurUpdated.setProduits(fournisseur.getProduits());
            fournisseurUpdated.setPersonne(fournisseur.getPersonne());
            fournisseurUpdated.setNom(fournisseur.getNom());
            daoFournisseur.save(fournisseurUpdated);
        });
        logger.info("Update fournisseur :" + fournisseur);
    }
    // → suppression
    public void delete(Long code) {
		if (code == null) {
			throw new ReferenceNullException();
		}
        Optional<Fournisseur> fournisseurSuprimer = daoFournisseur.findById(code.intValue());
        logger.debug("suprression de " + fournisseurSuprimer.hashCode());
        daoFournisseur.deleteById(code.intValue());
	}
    // → recherche tel/mail/nom/n° client
    public List<Fournisseur> findByNom(String nom){
        if (nom == null || nom.isBlank()){
            logger.debug("nom vide");
            throw new FournisseurException("nom indiqué invalide");
        }
        return daoFournisseur.findByNomContaining(nom);
    }

    public Fournisseur findByMail(String email){
        if (email == null || email.isBlank()){
            logger.debug("email vide");
            throw new FournisseurException("email indiqué invalide");
        }
        return daoFournisseur.findByMail(email).orElseThrow(() -> {
			throw new NotFoundException("fournisseur avec l'email  " + email + " inexistant");
		});
    }
    public Fournisseur findBytelephone(String telephone){
        if (telephone == null || telephone.isBlank()){
            logger.debug("telephone vide");
            throw new FournisseurException("telephone indiqué invalide");
        }
        return daoFournisseur.findByMail(telephone).orElseThrow(() -> {
			throw new NotFoundException("fournisseur avec le numero de telephone  " + telephone + " inexistant");
		});
    }

    public Fournisseur findById(Long id){
        return daoFournisseur.findById(id.intValue()).orElseThrow(() -> {
			throw new NotFoundException("fournisseur avec l'id  " + id + " inexistant");
		});
    }

    // → Tous les fournisseurs
    public List<Fournisseur> getAll(){
        return daoFournisseur.findAll();
    }
    //
}
