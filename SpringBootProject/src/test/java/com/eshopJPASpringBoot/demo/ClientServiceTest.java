package com.eshopJPASpringBoot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.services.ClientService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    void insertTest() {
        Client client = new Client("julian", "gaillard");
        clientService.creationClient(client);
        assertNotNull(client.getId());

        Client clientBdd = clientService.getClientId(client.getId());

        assertNotNull(clientBdd);
        assertEquals(client, clientBdd);
        assertEquals(client.getNom(), clientBdd.getNom());
        assertEquals(client.getPrenom(), clientBdd.getPrenom());
    }

    @Test
    void updateTest() {
        Client client = new Client("julian", "gaillard");
        clientService.creationClient(client);

        client.setNom("plus julian");
        clientService.updateClient(client);
        System.out.println(client.toString());

        Client clientUpdated = clientService.getClientId(client.getId());
        System.out.println(clientUpdated.toString());
        assertNotNull(clientUpdated);
        assertEquals("plus julian", clientUpdated.getNom());
    }

}
