import com.entities.Adresse;
import com.entities.Categorie;
import com.entities.Client;
import com.entities.Commande;
import com.entities.Fournisseur;
import com.entities.LigneCommande;
import com.entities.LigneCommandeId;
import com.entities.Personne;
import com.entities.Produit;
import java.util.*;
import com.repositories.implementation.JpaContext;
import com.repositories.interfaces.DaoAdresse;
import com.repositories.interfaces.DaoCategorie;
import com.repositories.interfaces.DaoClient;
import com.repositories.interfaces.DaoCommande;
import com.repositories.interfaces.DaoFournisseur;
import com.repositories.interfaces.DaoLigneCommande;
import com.repositories.interfaces.DaoPersonne;
import com.repositories.interfaces.DaoProduit;
import java.time.LocalDate;

public class AppTest {
    public static void main(String[] args) {

        DaoPersonne daoPersonne = JpaContext.getDaoPersonne();
        DaoProduit daoProduit = JpaContext.getDaoProduit();
        DaoCategorie daoCategorie = JpaContext.getDaoCategorie();
        DaoClient daoClient = JpaContext.getDaoClient();
        DaoAdresse daoAdresse = JpaContext.getDaoAdresse();
        DaoCommande daoCommande = JpaContext.getDaoCommande();
        DaoFournisseur daoFournisseur = JpaContext.getDaoFournisseur();
        DaoLigneCommande daoLigneCommande = JpaContext.getLigneCommande();

        Personne personne = new Personne();
        Produit produit = new Produit();
        Produit produit2 = new Produit();
        Categorie categorie = new Categorie();
        Categorie categorie2 = new Categorie();
        Categorie categorie3 = new Categorie();
        Adresse adresse = new Adresse();
        Adresse adresse2 = new Adresse();
        Commande commande1 = new Commande();
        Commande commande2 = new Commande();
        Client client = new Client();
        Fournisseur fournisseur = new Fournisseur();
        LigneCommande ligneCommande = new LigneCommande();

        personne.setNom("Beaver");
        personne.setMail("michel@forever");
        personne.setTelephone("98");
        daoPersonne.insert(personne);

        produit.setNom("Beaver plush");
        produit.setPrix(10.99);

        produit2.setNom("Beaver plush XL");
        produit2.setPrix(19.99);

        categorie.setNom("Je sais pas");
        daoCategorie.insert(categorie);

        categorie2.setNom("test parent");
        categorie2.setParent(categorie);
        daoCategorie.insert(categorie2);

        categorie3.setNom("test enfant");
        categorie3.setParent(categorie);
        daoCategorie.insert(categorie3);

        categorie.setChildren(Set.of(categorie2, categorie3));

        adresse.setCodePostal("55100");
        adresse.setNumero("1");
        adresse.setRue("Rue du Grand Bayard");
        adresse.setVille("Verdun");
        daoAdresse.insert(adresse);
        adresse2.setCodePostal("55200");
        adresse2.setNumero("1");
        adresse2.setRue("Rue du Grand Bayard");
        adresse2.setVille("Verdun");
        daoAdresse.insert(adresse2);

        commande1.setClient(client);
        commande1.setDate(LocalDate.of(2024, 4, 21));
        commande2.setClient(client);
        commande2.setDate(LocalDate.now());

        client.setAdresse(adresse);
        client.setMail("mathis@lover");
        client.setNom("Devil");
        client.setPrenom("Mathis");
        client.setTelephone("Le tient");
        daoClient.insert(client);
        daoCommande.insert(commande1);
        daoCommande.insert(commande2);

        fournisseur.setAdresse(adresse2);
        fournisseur.setNom("Michel & fils");
        fournisseur.setPersonne(personne);
        daoFournisseur.insert(fournisseur);

        produit.setFournisseur(fournisseur);
        produit2.setFournisseur(fournisseur);
        daoProduit.insert(produit);
        daoProduit.insert(produit2);

        fournisseur.setProduits(List.of(produit, produit2));
        daoFournisseur.update(fournisseur);

        ligneCommande.setQuantite(50);
        ligneCommande.setCommande(commande1);
        ligneCommande.setProduit(produit);
        ligneCommande.setId(new LigneCommandeId(commande1, produit));
        LigneCommande ligneCommande2 = new LigneCommande(new LigneCommandeId(commande1, produit2), 500);
        ligneCommande2.setCommande(commande1);
        ligneCommande2.setProduit(produit);
        daoLigneCommande.insert(ligneCommande);
        daoLigneCommande.insert(ligneCommande2);

        commande1.setLigneCommandes(Set.of(ligneCommande, ligneCommande2));
        daoCommande.update(commande1);
    }
}
