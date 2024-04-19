package com.repositories.implementation;

import java.util.List;

import com.entities.Produit;
import com.repositories.interfaces.DaoProduit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

class DaoProduitImpl implements DaoProduit {

    @Override
    public void insert(Produit obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Produit obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Produit obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.merge(obj));
        tx.commit();
        em.close();
    }

    @Override
    public void deleteByKey(Integer key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.find(DaoProduit.class, key));
        tx.commit();
        em.close();
    }

    @Override
    public Produit findByKey(Integer key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        return em.find(Produit.class, key);
    }

    @Override
    public List<Produit> findAll() {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        TypedQuery<Produit> query = em.createNamedQuery("select p from DaoProduit p", Produit.class);
        List<Produit> produits = query.getResultList();
        em.close();
        return produits;
    }

}
