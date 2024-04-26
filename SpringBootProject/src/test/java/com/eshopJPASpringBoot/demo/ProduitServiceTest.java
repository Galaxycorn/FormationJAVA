package com.eshopJPASpringBoot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.exceptions.NotFoundException;
import com.eshopJPASpringBoot.demo.services.ProduitService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class ProduitServiceTest {
	
	@Autowired
	ProduitService produitSrv;
	
	@Test
	void insertTest() {
		Produit p = new Produit("Product test", 10.10, "Super produit");
		produitSrv.creationProduit(p);
		assertNotNull(p.getNumero());
		Produit produitEnBase = produitSrv.findByNumero(p.getNumero());

		assertNotNull(produitEnBase);
		assertEquals(p, produitEnBase);
		assertEquals(p.getNom(), produitEnBase.getNom());
		assertEquals(p.getDescription(), produitEnBase.getDescription());
		assertEquals(p.getPrix(), produitEnBase.getPrix());
	}
	
	@Test
	void updateTest() {
		Produit p = new Produit("Product test", 10.10, "Super produit");
		produitSrv.creationProduit(p);
		
		p.setNom("New Product");
		produitSrv.updateProduit(p);
		System.out.println(p.toString());
		 
		Produit produitUpdated = produitSrv.findByNumero(p.getNumero());
        System.out.println(produitUpdated.toString());
        assertNotNull(produitUpdated);
        assertEquals("New Product", produitUpdated.getNom());
	}
	
	@Test
    void deleteTest() {
		Produit p = new Produit("Product test", 10.10, "Super produit");
		produitSrv.creationProduit(p);
		assertNotNull(p.getNumero());
		produitSrv.deleteProduit(p);
		assertThrows(NotFoundException.class, () -> produitSrv.findByNumero(p.getNumero()));
	}

}
