package TD1;

public class ComptePremium extends Compte {

    public ComptePremium(EnumCarte carte, double solde) {
        super(carte, solde - 150, Integer.MAX_VALUE, 0);
    }

}
