package TD2;

public class Humain implements InterfaceCarnivore, InterfaceHerbivore {

    public Humain() {

    }

    public void manger(Animal animal) {
        System.out.println("Humain mange " + animal);
    }

    public void manger(String plante) {
        System.out.println("Humain mange " + plante);
    }

    public void regime() {
        System.out.println("Humain est herbivore");
    }

}
