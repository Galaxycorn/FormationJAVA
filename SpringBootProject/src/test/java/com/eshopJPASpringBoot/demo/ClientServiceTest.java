package com.eshopJPASpringBoot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eshopJPASpringBoot.demo.entities.Adresse;
import com.eshopJPASpringBoot.demo.entities.Client;
import com.eshopJPASpringBoot.demo.exceptions.NotFoundException;
import com.eshopJPASpringBoot.demo.services.ClientService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class ClientServiceTest {

    private Logger logger = LoggerFactory.getLogger(ClientServiceTest.class);

    @Autowired
    ClientService clientService;

    @Test
    void insertTest() {
        Client client = new Client("julian", "gaillard");
        clientService.creationClient(client);
        Client client2 = clientService.creationClient("test1", "test2");
        assertNotNull(client.getId());
        assertNotNull(client2.getId());

        Client clientBdd = clientService.getClientId(client.getId());
        Client clientBdd2 = clientService.getClientIdFetch(client2.getId()).get();
        assertNotNull(clientBdd);
        assertEquals(client, clientBdd);
        assertNotNull(clientBdd2);
        assertEquals(client2, clientBdd2);
    }

    @Test
    void updateTest() {
        Client client = new Client("julian", "gaillard");
        clientService.creationClient(client);
        assertNotNull(client.getId());
        client.setNom("plus julian");
        clientService.updateClient(client);
        System.out.println(client.toString());

        Client clientUpdated = clientService.getClientId(client.getId());
        System.out.println(clientUpdated.toString());
        assertNotNull(clientUpdated);
        assertEquals("plus julian", clientUpdated.getNom());
    }

    @Test
    void deleteTest() {
        Client client = new Client("julian", "gaillard");
        clientService.creationClient(client);
        assertNotNull(client.getId());

        clientService.deleteClient(client);
        assertThrows(NotFoundException.class, () -> clientService.getClientId(client.getId()));
    }

    @Test
    void deleteTestId() {
        Client client = new Client("julian", "gaillard");
        clientService.creationClient(client);
        assertNotNull(client.getId());

        clientService.deleteClient(client.getId());
        assertThrows(NotFoundException.class, () -> clientService.getClientId(client.getId()));
    }

    @Test
    void getNomTest() {
        Client client = new Client("GROS TEST", "PETIT NOM");
        clientService.creationClient(client);
        assertNotNull(client.getId());

        List<Client> clientBdd = clientService.getClientNom("PETIT NOM");
        logger.debug(clientBdd.toString());
        assertEquals("PETIT NOM", clientBdd.get(0).getNom());
    }

    @Test
    void getTelTest() {
        Client client = new Client("julian", "gaillard", "07?74?82??", "mathislover@darkMathis", new Adresse());
        clientService.creationClient(client);
        assertNotNull(client.getId());

        Client clientBdd = clientService.getClientTelephone("07?74?82??").get();
        assertEquals(client, clientBdd);

    }

    @Test
    void getMailTest() {
        Client client = new Client("julian", "gaillard", "07?74?82??", "mathislover@darkMathis", new Adresse());
        clientService.creationClient(client);
        assertNotNull(client.getId());

        Client clientBdd = clientService.getClientMail("mathislover@darkMathis").get();
        assertEquals(client, clientBdd);
    }

    @Test
    void getAdresseTest() {
        Adresse adresse = new Adresse("42", "Oui", "non", "Paris");
        Client client = new Client("julian", "gaillard", "07?74?82??", "mathislover@darkMathis", adresse);
        clientService.creationClient(client);
        assertNotNull(client.getId());

        List<Client> clientsBdd = clientService.getClientAdresse("mathislover@darkMathis");
        for (Client clientBdd : clientsBdd) {
            assertEquals("Paris", clientBdd.getAdresse().getVille());
        }
    }

    @Test
    void getIdTest() {
        Client client = new Client("julian", "gaillard");
        clientService.creationClient(client);
        assertNotNull(client.getId());

        assertEquals(client, clientService.getClientId(client.getId()));
    }

    @Test
    void getAllTest() {
        Client client = new Client("julian", "gaillard");
        Client client2 = new Client("mathis", "Coiraton");
        Client client3 = new Client("Clément", "Hinz");
        clientService.creationClient(client);
        clientService.creationClient(client2);
        clientService.creationClient(client3);

        List<Client> clientsBdd = clientService.getAllClients();

        assertEquals(client, clientsBdd.get(0));
        assertEquals(client2, clientsBdd.get(1));
        assertEquals(client3, clientsBdd.get(2));
    }

}
