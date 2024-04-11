package TD1;

public class ComptePayant extends Compte {

    public ComptePayant(EnumCarte carte, double solde, int decouvert) {
        super(carte, solde - 50, decouvert, 1);

    }

}
