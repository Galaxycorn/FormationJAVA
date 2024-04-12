package TD3;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

public class Disque {

    private String nom;
    private String codeBarre;
    private Set<Chanson> chansons;

    public Disque(String nom, String codeBarre) {
        this.nom = nom;
        this.codeBarre = codeBarre;
        chansons = new HashSet<>();
    }

    public void addChanson(Chanson chanson) {
        chansons.add(chanson);
    }

    public int getDuree() {
        int sum = 0;
        for (Chanson chanson : chansons) {
            sum += chanson.getDuree();
        }
        return sum;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodeBarre() {
        return this.codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Set<Chanson> getChansons() {
        return this.chansons;
    }

    public void setChansons(Set<Chanson> chansons) {
        this.chansons = chansons;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Disque)) {
            return false;
        }
        Disque disque = (Disque) o;
        return Objects.equals(nom, disque.nom) && Objects.equals(codeBarre, disque.codeBarre)
                && Objects.equals(chansons, disque.chansons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, codeBarre, chansons);
    }

    @Override
    public String toString() {
        return "{" +
                " nom=" + getNom() +
                ", codeBarre=" + getCodeBarre() +
                ", chansons=" + getChansons() +
                "}";
    }

}
