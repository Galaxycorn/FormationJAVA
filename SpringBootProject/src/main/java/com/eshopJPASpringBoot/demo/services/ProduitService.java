package com.eshopJPASpringBoot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Categorie;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.repositories.DaoProduit;

@Service
public class ProduitService {
	 @Autowired
	    private DaoProduit daoProduit;
	 
	 public Produit creationProduit(String nom, Double prix, String description, Byte[] photo, Fournisseur fournisseur,  Categorie categorie) {
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
     public Produit updateProduit(Long numero, String nom, Double prix, String description, Byte[] photo, Fournisseur fournisseur,  Categorie categorie) {
         Produit produit = daoProduit.findByNumero(numero);
         if (produit != null) {
        	 produit.setNom(nom);
        	 produit.setPrix(prix);
        	 produit.setDescription(description);
        	 produit.setPhoto(photo);
        	 produit.setFournisseur(fournisseur);
        	 produit.setCategorie(categorie);
             return daoProduit.save(produit);
         }
         return null; 
     }
     
     public Produit updateProduit(Produit produit) {
         if (produit == null) {
             throw new ReferenceNullException();
         }
         daoProduit.findById(produit.getByNumero()).ifPresent(clientUpdated -> {
             clientUpdated.setAdresse(client.getAdresse());
             clientUpdated.setCommandes(client.getCommandes());
             clientUpdated.setMail(client.getMail());
             clientUpdated.setNom(client.getNom());
             clientUpdated.setPrenom(client.getPrenom());
             clientUpdated.setTelephone(client.getTelephone());

             daoClient.save(clientUpdated);
         });
         logger.info("Update client :" + client);
     }

 return daoClient.findById(id).orElseThrow(() -> {
             throw new NotFoundException("client " + id + "inexistant");
         });
     public void delete(Long numero) {
    	if (numero != null) {
    		 daoProduit.deleteById(numero);
 		}
       
     }
     public Produit findByNumero(Long code) {
 		if (code != null) {
 			return daoProduit.findByNumero(code);
 		}
		return null;
 	}
     
}
