package com.repositories.implementation;

import java.util.List;

import com.entities.Categorie;
import com.repositories.interfaces.DaoCategorie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

class DaoCategorieImpl implements DaoCategorie {

    @Override
    public void insert(Categorie obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Categorie obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Categorie obj) {
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
        em.remove(em.find(DaoCategorie.class, key));
        tx.commit();
        em.close();
    }

    @Override
    public Categorie findByKey(Integer key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        return em.find(Categorie.class, key);
    }

    @Override
    public List<Categorie> findAll() {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        TypedQuery<Categorie> query = em.createNamedQuery("select ca from DaoCategorie ca", Categorie.class);
        List<Categorie> DaoCategories = query.getResultList();
        em.close();
        return DaoCategories;
    }

}
