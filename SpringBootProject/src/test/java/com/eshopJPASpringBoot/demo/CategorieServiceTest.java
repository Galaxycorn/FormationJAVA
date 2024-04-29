package com.eshopJPASpringBoot.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Categorie;
import com.eshopJPASpringBoot.demo.exceptions.CategorieException;
import com.eshopJPASpringBoot.demo.exceptions.NotFoundException;
import com.eshopJPASpringBoot.demo.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.demo.services.CategorieService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class CategorieServiceTest {
    @Autowired
    CategorieService categorieService;

    @Test
    void injectionTest() {
        assertNotNull(categorieService);
    }

    @Test
    void creationTest() {
        Categorie cat = new Categorie("testCat");
        categorieService.creationCategorie(cat);
        assertNotNull(cat.getId());
        Categorie catEnBase = categorieService.findById(cat.getId());
        assertNotNull(catEnBase);
        assertEquals(cat, catEnBase);
        assertEquals(cat.getChildren(), catEnBase.getChildren());
        assertEquals(cat.getId(), catEnBase.getId());
        assertEquals(cat.getNom(), catEnBase.getNom());
        assertEquals(cat.getParent(), catEnBase.getParent());
        assertEquals(cat.getProduits(), catEnBase.getProduits());
    }

    @Test
    void deleteTest() {
        Categorie cat = new Categorie("testCatDel");
        categorieService.creationCategorie(cat);
        categorieService.delete(cat.getId());
        assertThrows(NotFoundException.class, () -> categorieService.findById(cat.getId()));
    }

    @Test
    void findByIdTest() {
        Categorie cat = new Categorie("testCat");
        categorieService.creationCategorie(cat);
        assertEquals(categorieService.findById(cat.getId()).getId(), cat.getId());
    }

    @Test
    void getAllTest() {
        Categorie cat1 = categorieService.creationCategorie("cat1");
        Categorie cat2 = categorieService.creationCategorie("cat2");
        List<Categorie> listCat = new ArrayList<Categorie>();
        listCat.add(cat1);
        listCat.add(cat2);
        assertEquals(categorieService.getAll(), listCat);
    }

    @Test
    void exceptionTest() {
        // @formatter:off
        assertAll( "test exception",
            () -> assertThrows(ReferenceNullException.class, () -> {
                Categorie cat = null;
                categorieService.creationCategorie(cat);
            }),
            () -> assertThrows(CategorieException.class, () -> {
                Categorie cat = new Categorie();
                categorieService.creationCategorie(cat);
            }),
            ()-> assertThrows(NotFoundException.class, ()->{
                categorieService.findById((long) 9999999);
            })
        );
        // @formatter:on
    }
}
