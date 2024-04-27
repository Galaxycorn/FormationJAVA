package com.eshopJPASpringBoot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.entities.Commande;
import com.eshopJPASpringBoot.demo.entities.Produit;
import com.eshopJPASpringBoot.demo.services.ClientService;
import com.eshopJPASpringBoot.demo.services.CommandeService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class CommandeServiceTest {

    @Autowired
    CommandeService commandeService;

    @Autowired
    ClientService clientService;

    private static Map<Produit, Integer> contenu;
    private static Client client;

    @BeforeEach
    void createContenu() {
        contenu = new HashMap<Produit, Integer>() {
            {
                put(new Produit("Test1", 87.90), 10);
                put(new Produit("Test2", 10.99), 1000);
            }
        };
        client = new Client("Michel", "Michel");
        clientService.creationClient(client);
    }

    @Test
    void creationTest() {
        Commande commande = commandeService.creationCommande(client, contenu);
        assertNotNull(commande);

        Commande commandeBdd = commandeService.getCommandeId(commande.getId());
        assertEquals(commande, commandeBdd);
    }

    @Test
    void deleteTest() {
        Commande commande = commandeService.creationCommande(client, contenu);
        assertNotNull(commande);
        commandeService.deleteCommande(commande);
        assertThrows(NoSuchElementException.class, () -> commandeService.getCommandeId(commande.getId()));

    }

    @Test
    void getDateTest() {
        Commande commande = commandeService.creationCommande(client, contenu);
        assertNotNull(commande);
        List<Commande> commandeBdd = commandeService.getCommandeDate(commande.getDate());
        assertEquals(commande, commandeBdd.get(0));
    }

    @Test
    void getClientTest() {
        Commande commande = commandeService.creationCommande(client, contenu);
        assertNotNull(commande);
        List<Commande> commandeBdd = commandeService.getCommandeClient(client);
        assertEquals(commande, commandeBdd.get(0));
    }

}
