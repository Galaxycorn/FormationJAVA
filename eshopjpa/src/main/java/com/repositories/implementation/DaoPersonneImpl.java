package com.repositories.implementation;

import java.util.List;

import com.entities.Personne;
import com.repositories.interfaces.DaoPersonne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

class DaoPersonneImpl implements DaoPersonne {

    @Override
    public void insert(Personne obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Personne obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Personne obj) {
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
        em.remove(em.find(DaoPersonne.class, key));
        tx.commit();
        em.close();
    }

    @Override
    public Personne findByKey(Integer key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        return em.find(Personne.class, key);
    }

    @Override
    public List<Personne> findAll() {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        TypedQuery<Personne> query = em.createNamedQuery("select c from Personne c", Personne.class);
        List<Personne> daoPersonnes = query.getResultList();
        em.close();
        return daoPersonnes;
    }

}
