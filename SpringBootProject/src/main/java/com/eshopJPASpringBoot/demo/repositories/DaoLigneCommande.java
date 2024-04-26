package com.eshopJPASpringBoot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopJPASpringBoot.demo.entities.LigneCommande;
import com.eshopJPASpringBoot.demo.entities.LigneCommandeId;

public interface DaoLigneCommande extends JpaRepository<LigneCommande, LigneCommandeId> {

}
