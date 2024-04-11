package TD1;

class Main {

    public static void main(String[] args) {
        CompteSimple compteSimple = new CompteSimple(EnumCarte.VISA, 10000);
        ComptePayant comptePayant = new ComptePayant(EnumCarte.MASTERCARD, 150000, 70);
        ComptePremium comptePremium = new ComptePremium(EnumCarte.CB, 5000000);
        System.out.println(compteSimple.toString());
        System.out.println(comptePayant.toString());
        System.out.println(comptePremium.toString());

        compteSimple.verser(comptePremium, 10000000);
        System.out.println(compteSimple.toString());
        System.out.println(comptePremium.toString());

        System.out.println(Compte.sommeBanque());
    }
}