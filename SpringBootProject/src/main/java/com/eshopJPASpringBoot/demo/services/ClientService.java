package com.eshopJPASpringBoot.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Adresse;
import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.entities.Commande;
import com.eshopJPASpringBoot.demo.exceptions.ClientException;
import com.eshopJPASpringBoot.demo.exceptions.NotFoundException;
import com.eshopJPASpringBoot.demo.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.demo.repositories.DaoClient;

@Service
public class ClientService {

    private Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private DaoClient daoClient;

    public Client creationClient(String prenom, String nom, String telephone, String mail, List<Commande> commandes,
            Adresse adresse) {
        return creationClient(new Client(prenom, nom, telephone, mail, commandes, adresse));
    }

    public Client creationClient(String prenom, String nom) {
        Client client = new Client();
        client.setPrenom(prenom);
        client.setNom(nom);
        logger.info("Création client :" + client);
        return creationClient(client);
    }

    public Client creationClient(Client client) {
        if (client == null)
            throw new ReferenceNullException();
        if (client.getNom() == null || client.getNom().isBlank())
            throw new ClientException("Nom obligatoire");
        logger.info("Création client :" + client);
        return daoClient.save(client);

    }

    public void updateClient(Client client) {
        if (client == null) {
            throw new ReferenceNullException();
        }
        daoClient.findById(client.getId()).ifPresent(clientUpdated -> {
            clientUpdated.setAdresse(client.getAdresse());
            clientUpdated.setCommandes(client.getCommandes());
            clientUpdated.setMail(client.getMail());
            clientUpdated.setNom(client.getNom());
            clientUpdated.setPrenom(client.getPrenom());
            clientUpdated.setTelephone(client.getTelephone());

            daoClient.save(clientUpdated);
        });
        logger.info("Update client :" + client);
    }

    public void deleteClient(Integer id) {
        if (id == null)
            throw new ReferenceNullException();
        logger.info("Client supprimé :" + getClientId(id));
        daoClient.deleteById(id);
    }

    public void deleteClient(Client client) {
        if (client == null)
            throw new ReferenceNullException();
        deleteClient(client.getId());
    }

    public Optional<Client> getClientTelephone(String telephone) {
        if (telephone == null || telephone.isBlank())
            throw new ReferenceNullException();
        return daoClient.findByTelephone(telephone);
    }

    public Optional<Client> getClientMail(String mail) {
        if (mail == null || mail.isBlank())
            throw new ReferenceNullException();
        return daoClient.findByMail(mail);
    }

    public List<Client> getClientNom(String nom) {
        if (nom == null || nom.isBlank())
            throw new ReferenceNullException();
        logger.debug("debug nom" + nom);
        return daoClient.findByNomContaining(nom);
    }

    public Client getClientId(Integer id) {
        if (id == null)
            throw new ReferenceNullException();
        return daoClient.findById(id).orElseThrow(() -> {
            throw new NotFoundException("client " + id + "inexistant");
        });
    }

    public List<Client> getClientAdresse(String ville) {
        if (ville == null || ville.isBlank())
            throw new ReferenceNullException();
        return daoClient.findByVille(ville);
    }

    public Optional<Client> getClientIdFetch(Integer id) {
        if (id == null)
            throw new ReferenceNullException();
        return daoClient.findByIdFetchCommandes(id.longValue());
    }

    public List<Client> getAllClients() {
        return daoClient.findAll();
    }

}
