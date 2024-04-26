package com.eshopJPASpringBoot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.services.ProduitService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class ProduitServiceTest {
	
	@Autowired
	ProduitService produitSrv;
	
	@Test
	void injectionTest() {
		assertNotNull(produitSrv);
	}
	
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

}
