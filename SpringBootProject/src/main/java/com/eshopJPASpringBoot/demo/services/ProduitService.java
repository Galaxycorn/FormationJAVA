package com.eshopJPASpringBoot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Categorie;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.demo.repositories.DaoProduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProduitService {
	
	 private Logger logger = LoggerFactory.getLogger(ProduitService.class);
	 
	 @Autowired
	    private DaoProduit daoProduit;
	 
	 public Produit creationProduit(String nom, Double prix, String description, String photo, Fournisseur fournisseur,  Categorie categorie) {
		 if (prix > 0) {
			   return creationProduit(new Produit(nom, prix, description, photo, fournisseur,categorie));
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
            return null;
        }
        return daoProduit.save(produit);

     }
     public void updateProduit(Long numero, String nom, Double prix, String description, String photo, Fournisseur fournisseur,  Categorie categorie) {
         Produit produit = daoProduit.findByNumero(numero);
         if (produit == null) {
             throw new ReferenceNullException();
         }
         else{
        	 produit.setNom(nom);
        	 produit.setPrix(prix);
        	 produit.setDescription(description);
        	 produit.setPhoto(photo);
        	 produit.setFournisseur(fournisseur);
        	 produit.setCategorie(categorie);
             daoProduit.save(produit);
         }
         logger.info("Update produit :" + produit);
        
     }
     public void updateProduit(Produit produit) {
         if (produit == null) {
             throw new ReferenceNullException();
         }
         daoProduit.findById(produit.getNumero().intValue()).ifPresent(produitUpdated -> {
        	 produitUpdated.setNom(produit.getNom());
        	 produitUpdated.setPrix(produit.getPrix());
        	 produitUpdated.setDescription(produit.getDescription());
        	 produitUpdated.setPhoto(produit.getPhoto());
        	 produitUpdated.setFournisseur(produit.getFournisseur());
        	 produitUpdated.setCategorie(produit.getCategorie());

        	 daoProduit.save(produitUpdated);
         });
         logger.info("Update produit :" + produit);
	
     }

     
     public void deleteProduit(Long numero) {
    	if (numero != null) {
    		 daoProduit.deleteById(numero);
 		}
       
     }
     public void deleteProduit(Produit produit) {
     	if (produit != null) {
     		 daoProduit.deleteById(produit.getNumero());
  		}
        
      }
     public Produit findByNumero(Long code) {
 		if (code != null) {
 			return daoProduit.findByNumero(code);
 		}
		return null;
 	}
     
}
