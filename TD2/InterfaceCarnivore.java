package TD2;

public interface InterfaceCarnivore {

    public default void manger(Animal animal) {
        System.out.println("Lyon mange Elephant");
    }

    public default void regime() {
        System.out.println("Lion est carnivore");
    }
}
