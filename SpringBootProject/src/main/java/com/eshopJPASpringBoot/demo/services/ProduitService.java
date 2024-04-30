package com.eshopJPASpringBoot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Categorie;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.exceptions.NotFoundException;
import com.eshopJPASpringBoot.demo.exceptions.ProduitException;
import com.eshopJPASpringBoot.demo.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.demo.repositories.DaoProduit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProduitService {

	private Logger logger = LoggerFactory.getLogger(ProduitService.class);

	@Autowired
	private DaoProduit daoProduit;

	@Autowired
	private FournisseurSerivce fournisseurSerivce;

	public Produit creationProduit(String nom, Double prix, String description, String photo, Fournisseur fournisseur,
			Categorie categorie) {
		if (prix > 0) {
			return creationProduit(new Produit(nom, prix, description, photo, fournisseur, categorie));
		}
		return null;
	}

	public Produit creationProduit(String nom, Double prix, String description) {
		if (prix > 0) {
			return creationProduit(new Produit(nom, prix, description));
		}
		return null;
	}

	public Produit creationProduit(Produit produit) {
		if (produit == null) {
			throw new ReferenceNullException();
		}
		if (produit.getNom() == null || produit.getNom().isBlank()) {
			throw new ProduitException("Manque un nom");
		}
		logger.info("Création produit : {}", produit);
		return daoProduit.save(produit);

	}

	public void updateProduit(Long numero, String nom, Double prix, String description, String photo,
			Fournisseur fournisseur, Categorie categorie) {
		Produit produit = daoProduit.findByNumero(numero);
		if (produit == null) {
			throw new ReferenceNullException();
		} else {
			produit.setNom(nom);
			produit.setPrix(prix);
			produit.setDescription(description);
			produit.setPhoto(photo);
			produit.setFournisseur(fournisseur);
			produit.setCategorie(categorie);
			daoProduit.save(produit);
		}
		logger.info("Update produit : {}", produit);

	}

	public Produit updateProduit(Produit produit) {
		if (produit == null) {
			throw new ReferenceNullException();
		}
		daoProduit.findById(produit.getNumero()).ifPresent(produitUpdated -> {
			produitUpdated.setNom(produit.getNom());
			produitUpdated.setPrix(produit.getPrix());
			produitUpdated.setDescription(produit.getDescription());
			produitUpdated.setPhoto(produit.getPhoto());
			produitUpdated.setFournisseur(produit.getFournisseur());
			produitUpdated.setCategorie(produit.getCategorie());

			daoProduit.save(produitUpdated);
		});
		logger.info("Update produit : {}", produit);
		return produit;

	}

	public void deleteProduit(Produit produit) {
		if (produit != null) {
			daoProduit.delete(produit);
		}
		logger.info("Delete produit : {}", produit);
	}

	public Produit findByNumero(Long code) {
		if (code == null) {
			throw new ReferenceNullException();
		}
		return daoProduit.findById(code).orElseThrow(() -> {
			throw new NotFoundException();
		});
	}

	public List<Produit> getAllProduits() {
		return daoProduit.findAll();
	}

	public List<Produit> getProduitByCat(Categorie cat) {
		if (cat == null)
			throw new ReferenceNullException();
		return daoProduit.findByCategorie(cat);
	}

	public List<Produit> getProduitByNom(String nom) {
		if (nom == null || nom.isBlank())
			throw new ReferenceNullException();
		return daoProduit.findByNomContaining(nom);
	}

	public void checkFournisseur(Produit produit, Fournisseur fournisseur) {
		if (produit == null || fournisseur == null)
			throw new ReferenceNullException();
		fournisseurSerivce.findById(fournisseur.getId());
		this.findByNumero(produit.getNumero());
	}

	public void ajouterFournisseur(Produit produit, Fournisseur fournisseur) {
		checkFournisseur(produit, fournisseur);
		produit.setFournisseur(fournisseur);
		daoProduit.save(produit);
	}

}
