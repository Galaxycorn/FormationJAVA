package TD3;

public class Chanson {

    private String nom;
    private int duree;

    public Chanson(String nom, int duree) {
        this.nom = nom;
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "{" +
                "Nom = " + getNom() +
                " : durée = " + getDuree() + " s" +
                "}";
    }

}
