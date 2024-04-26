package com.eshopJPASpringBoot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopJPASpringBoot.demo.entities.Adresse;

public interface DaoAdresse extends JpaRepository<Adresse, Integer> {

}
