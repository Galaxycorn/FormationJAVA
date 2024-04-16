package TD3;

public class Main {

    public static void main(String[] args) throws DisqueDejaPresentException {
        Chanson chanson1 = new Chanson("Mathis le plus beau", 90);
        Chanson chanson2 = new Chanson("Mathis le plus fort", 80);
        Chanson chanson3 = new Chanson("Mathis le plus mort", 60);

        Chanson chanson11 = new Chanson("EVIL Mathis le plus beau", 90);
        Chanson chanson12 = new Chanson("EVIL Mathis le plus fort", 80);
        Chanson chanson13 = new Chanson("EVIL Mathis le plus mort", 60);

        Disque disque = new Disque("Mathis", "4269");
        disque.addChanson(chanson1);
        disque.addChanson(chanson2);
        disque.addChanson(chanson3);

        Disque disqueEvil = new Disque("EVIL Mathis", "6942");
        disqueEvil.addChanson(chanson11);
        disqueEvil.addChanson(chanson12);
        disqueEvil.addChanson(chanson13);

        Bibliotheque bibliotheque = new Bibliotheque("MATHIS I<3U");
        bibliotheque.ajouterDisque(disque);
        bibliotheque.ajouterDisque(disqueEvil);

        System.out.println(bibliotheque.rechercherDisque("Mathis"));
        System.out.println("_________________________");
        System.out.println(bibliotheque.rechercherChansons("Mathis"));
        System.out.println("_________________________");
        System.out.println("Il y a " + bibliotheque.getNbDisques() + " disque(s) dans la bibliothèque");
        System.out.println("_________________________");
        System.out.println(bibliotheque.getDisque("6942"));
        System.out.println("_________________________");
        System.out.println(bibliotheque.retirerDisque("6942"));
        System.out.println("_________________________");
        System.out.println(bibliotheque.rechercherDisque("Mathis"));
    }

}
