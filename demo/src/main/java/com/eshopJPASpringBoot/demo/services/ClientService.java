package com.eshopJPASpringBoot.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Adresse;
import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.entities.Commande;
import com.eshopJPASpringBoot.demo.repositories.DaoClient;

@Service
public class ClientService {

    @Autowired
    private DaoClient daoClient;

    public Client creationClient(String prenom, String nom, List<Commande> commandes, Adresse adresse) {
        return creationClient(new Client(prenom, nom, commandes, adresse));
    }

    public Client creationClient(Client client) {
        if (client == null) {
            return null;
        }
        return daoClient.save(client);

    }
}
