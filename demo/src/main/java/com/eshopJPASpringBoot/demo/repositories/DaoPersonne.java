package com.eshopJPASpringBoot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopJPASpringBoot.demo.entities.Personne;

public interface DaoPersonne extends JpaRepository<Personne, Integer> {

}
