package com.eshopJPASpringBoot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopJPASpringBoot.demo.entities.Categorie;

public interface DaoCategorie extends JpaRepository<Categorie, Integer> {

}
