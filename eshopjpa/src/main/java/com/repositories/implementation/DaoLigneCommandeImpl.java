package com.repositories.implementation;

import java.util.List;

import com.entities.LigneCommande;
import com.entities.LigneCommandeId;
import com.repositories.interfaces.DaoLigneCommande;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

class DaoLigneCommandeImpl implements DaoLigneCommande {

    @Override
    public void insert(LigneCommande obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void update(LigneCommande obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(LigneCommande obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.merge(obj));
        tx.commit();
        em.close();
    }

    @Override
    public void deleteByKey(LigneCommandeId key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.find(DaoLigneCommande.class, key));
        tx.commit();
        em.close();
    }

    @Override
    public LigneCommande findByKey(LigneCommandeId key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        return em.find(LigneCommande.class, key);
    }

    @Override
    public List<LigneCommande> findAll() {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        TypedQuery<LigneCommande> query = em.createNamedQuery("select ca from DaoLigneCommande ca",
                LigneCommande.class);
        List<LigneCommande> DaoLigneCommandes = query.getResultList();
        em.close();
        return DaoLigneCommandes;
    }

}
