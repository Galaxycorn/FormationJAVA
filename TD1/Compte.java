package TD1;

public abstract class Compte {

    private static int nextCode;
    private int code;
    protected static int sommeInteret;
    private static int nombreOperation;
    private int interet;
    private double solde;
    private int decouvert;
    EnumCarte carte;

    public Compte(EnumCarte carte, double solde, int decouvert, int interet) {
        nextCode++;
        this.code = nextCode;
        this.carte = carte;
        this.solde = solde;
        this.decouvert = decouvert;
        this.interet = interet;
        solde -= carte.getValeur();
    }

    public void retirer(double valeur) {
        if (this.getSolde() - valeur < decouvert)
            System.out.println("Vous dépasser votre découvert autorisé");
        else {
            nombreOperation++;
            this.setSolde(this.getSolde() - valeur - this.getInteret());
            sommeInteret += this.getInteret();
        }
    }

    public void verser(double valeur) {
        this.setSolde(this.getSolde() + valeur);
    }

    public void verserCompte(Compte compte, double valeur) {
        if (this.getSolde() - valeur < decouvert)
            System.out.println("Vous dépasser votre découvert autorisé");
        else {
            nombreOperation++;
            compte.setSolde(compte.getSolde() + valeur - compte.getInteret());
            this.setSolde(this.getSolde() - valeur - this.getInteret());
            sommeInteret += interet * 2;
        }
    }

    public String toString() {
        return "Valeur du compte n°" + code + " est a un solde de : " + solde + " et possède une carte : " + carte
                + " puis paie cette somme d'interet " + interet;
    }

    public static String sommeBanque() {
        return String.valueOf(sommeInteret);
    }

    public static String nombreOperation() {
        return String.valueOf(nombreOperation);
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getInteret() {
        return interet;
    }

}
