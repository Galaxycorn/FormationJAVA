package TD2;

public interface InterfaceHerbivore {

    public default void manger(String plante) {
        System.out.println("Elephant mange herbe");
    }

    public default void regime() {
        System.out.println("Girafe est herbivore");
    }
}
