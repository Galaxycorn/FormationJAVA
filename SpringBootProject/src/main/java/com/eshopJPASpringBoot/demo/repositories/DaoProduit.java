package com.eshopJPASpringBoot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopJPASpringBoot.demo.entities.Categorie;
import com.eshopJPASpringBoot.demo.entities.Fournisseur;
import com.eshopJPASpringBoot.demo.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface DaoProduit extends JpaRepository<Produit, Long> {

    List<Produit> findByNomContaining(String nom);
    
    Produit findByNumero(Long numero);

    List<Produit> findByFournisseur(Fournisseur fournisseur);

    List<Produit> findByCategorie(Categorie categorie);

    Optional<Produit> findByPrixBetween(double min, double max);
    
    List<Produit> findAll();

}
