package TD1;

public enum EnumCarte {
    CB(0), VISA(5), MASTERCARD(10);

    private final int valeur;

    private EnumCarte(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return this.valeur;
    }
}
