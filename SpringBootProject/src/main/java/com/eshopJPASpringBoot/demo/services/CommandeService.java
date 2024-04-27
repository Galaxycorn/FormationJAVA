package com.eshopJPASpringBoot.demo.services;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.entities.Commande;
import com.eshopJPASpringBoot.demo.entities.LigneCommande;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.exceptions.ReferenceNullException;
import com.eshopJPASpringBoot.demo.repositories.DaoCommande;

@Service
public class CommandeService {

    private Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    DaoCommande daoCommande;

    public Commande creationCommande(Client client, Map<Produit, Integer> contenu) {
        if (client == null || contenu.isEmpty())
            throw new ReferenceNullException();
        logger.info("Création d'une commande avec " + contenu.toString());
        Set<LigneCommande> ligneCommandes = new HashSet<>();
        for (Map.Entry<Produit, Integer> entry : contenu.entrySet()) {
            LigneCommande ligneCommande = new LigneCommande(entry.getKey(), entry.getValue());
            ligneCommandes.add(ligneCommande);
        }

        return daoCommande.save(new Commande(client, ligneCommandes));
    }

    public Commande getCommandeId(Long id) {
        if (id == null)
            throw new ReferenceNullException();
        return daoCommande.findById(id).get();
    }

    public Optional<Commande> getCommandetIdFetch(Integer id) {
        if (id == null)
            throw new ReferenceNullException();
        return daoCommande.findByIdFetchLigne(id.longValue());
    }

    public List<Commande> getCommandeClient(Client client) {
        if (client == null)
            throw new ReferenceNullException();
        return daoCommande.findByClient(client);
    }

    public List<Commande> getCommandeDate(LocalDate localDate) {
        if (localDate == null)
            throw new ReferenceNullException();
        return daoCommande.findByDate(localDate);
    }

    public void deleteCommande(Long id) {
        if (id == null)
            throw new ReferenceNullException();
        logger.info("Client supprimé :" + getCommandeId(id));
        daoCommande.deleteById(id);
    }

    public void deleteCommande(Commande commande) {
        if (commande == null)
            throw new ReferenceNullException();
        deleteCommande(commande.getId());
    }

}
