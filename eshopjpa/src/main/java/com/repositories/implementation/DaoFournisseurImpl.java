package com.repositories.implementation;

import java.util.List;

import com.entities.Fournisseur;
import com.repositories.interfaces.DaoFournisseur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

class DaoFournisseurImpl implements DaoFournisseur {

    @Override
    public void insert(Fournisseur obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Fournisseur obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Fournisseur obj) {
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
        em.remove(em.find(DaoFournisseur.class, key));
        tx.commit();
        em.close();
    }

    @Override
    public Fournisseur findByKey(Integer key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        return em.find(Fournisseur.class, key);
    }

    @Override
    public List<Fournisseur> findAll() {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        TypedQuery<Fournisseur> query = em.createNamedQuery("select ca from DaoFournisseur ca", Fournisseur.class);
        List<Fournisseur> DaoFournisseurs = query.getResultList();
        em.close();
        return DaoFournisseurs;
    }

}
