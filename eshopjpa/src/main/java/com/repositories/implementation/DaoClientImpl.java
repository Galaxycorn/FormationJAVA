package com.repositories.implementation;

import java.util.List;

import com.entities.Client;
import com.repositories.interfaces.DaoClient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

class DaoClientImpl implements DaoClient {

    @Override
    public void insert(Client obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Client obj) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(obj);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Client obj) {
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
        em.remove(em.find(DaoClient.class, key));
        tx.commit();
        em.close();
    }

    @Override
    public Client findByKey(Integer key) {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        return em.find(Client.class, key);
    }

    @Override
    public List<Client> findAll() {
        EntityManager em = null;
        em = JpaContext.getEntityManagerFactory().createEntityManager();
        TypedQuery<Client> query = em.createNamedQuery("select c from Client c", Client.class);
        List<Client> daoClients = query.getResultList();
        em.close();
        return daoClients;
    }

}
