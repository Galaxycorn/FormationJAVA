package com.eshopJPASpringBoot.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eshopJPASpringBoot.demo.entities.Client;

public interface DaoClient extends JpaRepository<Client, Integer> {

    List<Client> findByNomContaining(String nom);

    @Query("select c from Client c left join fetch c.adresse a where a.ville=:ville")
    List<Client> findByVille(@Param("ville") String ville);

    Optional<Client> findByMail(String mail);

    Optional<Client> findByTelephone(String telephone);

    @Query("select c from Client c left join fetch c.commandes where c.id=:id")
    Optional<Client> findByIdFetchCommandes(@Param("id") Long id);
}
