package TD3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Bibliotheque {

    private Set<Disque> disques;
    private String nom;

    public Bibliotheque(String nom) {
        this.nom = nom;
        disques = new HashSet<>();
    }

    public void ajouterDisque(Disque disque) throws DisqueDejaPresentException {
        if (disques.contains(disque))
            throw new DisqueDejaPresentException("Disque déjà présent dans la liste");
        else
            disques.add(disque);
    }

    public boolean retirerDisque(String codeBarre) {
        for (Disque disque : disques) {
            if (disque.getCodeBarre() == codeBarre) {
                disques.remove(disque);
                return true;
            }
        }
        return false;
    }

    public int getNbDisques() {
        return disques.size();
    }

    public Disque getDisque(String codeBarre) {
        for (Disque disque : disques) {
            if (disque.getCodeBarre() == codeBarre)
                return disque;
        }
        return null;
    }

    public List<Disque> rechercherDisque(String recherche) {
        List<Disque> casse = new ArrayList<>();
        for (Disque disque : disques) {
            if (disque.getNom().contains(recherche))
                casse.add(disque);
        }
        return casse;
    }

    public List<Disque> rechercherDisquesStream(String recherche) {
        return disques.stream().filter(disque -> disque.getNom().toLowerCase().contains(recherche.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Chanson> rechercherChansons(String recherche) {
        List<Chanson> casse = new ArrayList<>();
        for (Disque disque : disques) {
            for (Chanson chanson : disque.getChansons()) {
                if (chanson.getNom().contains(recherche))
                    casse.add(chanson);
            }
        }
        return casse;
    }

    public List<Chanson> rechercherChansonsStream(String recherche) {
        return disques.stream().flatMap(disque -> disque.getChansons().stream())
                .filter(chanson -> chanson.getNom().toUpperCase()
                        .contains(recherche.toUpperCase()))
                .collect(Collectors.toList());
    }

    /**
     * @return Set<Disque> return the disques
     */
    public Set<Disque> getDisques() {
        return disques;
    }

    /**
     * @param disques the disques to set
     */
    public void setDisques(Set<Disque> disques) {
        this.disques = disques;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

}
