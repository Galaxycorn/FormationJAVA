import com.entities.Categorie;
import com.entities.Personne;
import com.entities.Produit;
import com.repositories.implementation.JpaContext;
import com.repositories.interfaces.DaoCategorie;
import com.repositories.interfaces.DaoPersonne;
import com.repositories.interfaces.DaoProduit;

public class AppTest {
    public static void main(String[] args) {

        DaoPersonne daoPersonne = JpaContext.getDaoPersonne();
        DaoProduit daoProduit = JpaContext.getDaoProduit();
        DaoCategorie daoCategorie = JpaContext.getDaoCategorie();

        Personne Personne = new Personne();
        Personne.setNom("Beaver");
        Personne.setMail("michel@forever");
        Personne.setTelephone("98");

        Produit produit = new Produit();
        produit.setNom("Beaver plush");
        produit.setPrix(10.99);

        Categorie categorie = new Categorie();
        categorie.setNom("Je sais pas");

        daoPersonne.insert(Personne);
        daoProduit.insert(produit);
        daoCategorie.insert(categorie);
    }
}
