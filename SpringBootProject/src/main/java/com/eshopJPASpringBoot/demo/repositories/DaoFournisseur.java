package com.eshopJPASpringBoot.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eshopJPASpringBoot.demo.entities.Fournisseur;

public interface DaoFournisseur extends JpaRepository<Fournisseur, Integer> {

    List<Fournisseur> findByNomFournisseur(String nomFournisseur);
    
    Optional<Fournisseur> findByMail(String mail);

    Optional<Fournisseur> findByTelephone(String telephone);

    @Query("select f from Fournisseur f left join fetch f.produits where f.id=:id")
    Optional<Fournisseur> findByIdFetchProduit(@Param("id") Long id);

    @Query("select f from Fournisseur f left join fetch f.adresse a where a.ville=:ville")
    List<Fournisseur> findByVille(@Param("ville") String ville);
    
}
