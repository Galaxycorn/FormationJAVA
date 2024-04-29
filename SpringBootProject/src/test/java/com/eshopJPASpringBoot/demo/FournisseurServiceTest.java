package com.eshopJPASpringBoot.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.exceptions.FournisseurException;
import com.eshopJPASpringBoot.demo.exceptions.NotFoundException;
import com.eshopJPASpringBoot.demo.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.demo.services.FournisseurSerivce;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class FournisseurServiceTest {
    @Autowired
    FournisseurSerivce fournisseurSerivce;

    @Test
    void injectionTest() {
        assertNotNull(fournisseurSerivce);
    }

    @Test
    void insertTest() {
        Fournisseur f = new Fournisseur("fourni test", null, null);
        fournisseurSerivce.creationFournisseur(f);
        assertNotNull(f.getFournisseurId());
        Fournisseur fourniEnBase = fournisseurSerivce.findById(f.getFournisseurId());
        assertNotNull(fourniEnBase);
        assertEquals(f, fourniEnBase);
        assertEquals(f.getAdresse(), fourniEnBase.getAdresse());
        assertEquals(f.getNom(), fourniEnBase.getNom());
        assertEquals(f.getMail(), fourniEnBase.getMail());
        assertEquals(f.getTelephone(), fourniEnBase.getTelephone());
        assertEquals(f.getProduits(), fourniEnBase.getProduits());
    }

    @Test
    void exceptionTest() {
        // @formatter:off
		assertAll("test exception",
						()->assertThrows(ReferenceNullException.class, () -> {
								fournisseurSerivce.creationFournisseur(null);
						}),
						()->assertThrows(FournisseurException.class, () -> {
								Fournisseur f=new Fournisseur();
								fournisseurSerivce.creationFournisseur(f);
						}),
						()->assertThrows(NotFoundException.class, ()->{
                                fournisseurSerivce.findById(99999999);
						}));
		// @formatter:on

    }

    @Test
    void deleteTest() {
        Fournisseur f = fournisseurSerivce.creationFournisseur("testDel", null, null);
        Integer id = f.getFournisseurId();
        fournisseurSerivce.delete(id);
        assertThrows(NotFoundException.class, () -> fournisseurSerivce.findById(id));
    }

    @Test
    void updateTest() {
        Fournisseur f = fournisseurSerivce.creationFournisseur("nom", null, null);
        Fournisseur fSansUpdate = new Fournisseur();
        fSansUpdate.setNom(f.getNom());
        f.setNom("nomModif");
        fournisseurSerivce.updateFournisseur(f);
        assertNotEquals(fournisseurSerivce.findById(f.getFournisseurId()), fSansUpdate);
    }

    @Test
    void findByIdTest() {
        Fournisseur f = fournisseurSerivce.creationFournisseur("nom", null, null);
        Integer id = f.getFournisseurId();
        assertEquals(fournisseurSerivce.findById(id).getFournisseurId(), id);
    }

    @Test
    void findByTelephoneTest() {
        Fournisseur f = fournisseurSerivce.creationFournisseur("nom", null, null);
        f.setTelephone("0783516196");
        String tel = f.getTelephone();
        assertEquals(fournisseurSerivce.findByTelephone(tel).getTelephone(), tel);
    }

    @Test
    void findByIdMailTest() {
        Fournisseur f = fournisseurSerivce.creationFournisseur("nom", null, null);
        f.setMail("m@mail.com");
        String mail = f.getMail();
        assertEquals(fournisseurSerivce.findByMail(mail).getMail(), mail);
    }

    @Test
    void findByNomTest() {
        Fournisseur f = fournisseurSerivce.creationFournisseur("nom", null, null);
        assertEquals(fournisseurSerivce.findByNom("nom").get(0), f);
    }

    @Test
    void findAllTest() {
        Fournisseur f = fournisseurSerivce.creationFournisseur("nom", null, null);
        assertEquals(fournisseurSerivce.getAll().get(0), f);
    }

}
