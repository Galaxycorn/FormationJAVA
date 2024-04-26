package com.eshopJPASpringBoot.demo;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Adresse;
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
	
	@Test
	void findAll() {
		Produit p1 = new Produit("Product test", 10.10, "Super produit");
		produitSrv.creationProduit(p1);
		assertNotNull(p1.getNumero());

		Produit p2 = new Produit("Product test2", 10.10, "Super produit");
		produitSrv.creationProduit(p2);
		assertNotNull(p2.getNumero());

		Produit p3 = new Produit("Product test3", 10.10, "Super produit");
		produitSrv.creationProduit(p3);
		assertNotNull(p3.getNumero());

		List<Produit> produitsBddList = produitSrv.getAllProduits();
		assertEquals(p1, produitsBddList.get(0));
		assertEquals(p2, produitsBddList.get(1));
		assertEquals(p3, produitsBddList.get(2));

	}
	
	@Test
	void getByIdTest() {
		Produit p1 = new Produit("Product test", 10.10, "Super produit");
		produitSrv.creationProduit(p1);
		assertNotNull(p1.getNumero());

		assertEquals(p1, produitSrv.findByNumero(p1.getNumero()));
	}
	
	@Test
	void getByNomTest() {
		Produit p1 = new Produit("Product test", 10.10, "Super produit");
		produitSrv.creationProduit(p1);
		assertNotNull(p1.getNumero());

		Produit produit = produitSrv.getProduitByNom("Product test").get(0);
		assertEquals(p1, produit);

	}

}
