package com.eshopJPASpringBoot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.entities.Commande;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface DaoCommande extends JpaRepository<Commande, Integer> {

    List<Commande> findByDate(LocalDate date);

    List<Commande> findByClient(Client client);

    @Query("select c from Commande c left join fetch c.ligneCommandes where c.id=:id")
    Optional<Commande> findByIdFetchLigne(@Param("id") Long id);
}
