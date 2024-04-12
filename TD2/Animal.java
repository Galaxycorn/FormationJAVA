package TD2;

public class Animal implements InterfaceCarnivore, InterfaceHerbivore {
    private String couleur;
    protected boolean carnivore;
    protected boolean herbivore;

    public Animal(String couleur, boolean carnivore, boolean herbivore) {
        this.couleur = couleur;
        this.carnivore = carnivore;
        this.herbivore = herbivore;
    }

    public Animal(String couleur) {
        this.couleur = couleur;
    }

    public void manger(Animal animal) {
        if (carnivore) {
            System.out.println(this.getClass().getSimpleName() + " mange " + animal.getClass().getSimpleName());
        }
    }

    public void manger(String plante) {
        if (herbivore) {
            System.out.println(this.getClass().getSimpleName() + " mange " + plante);
        }
    }

    public void regime() {
        if (carnivore && herbivore)
            System.out.println(this.getClass().getSimpleName() + " est omnivore");
        else if (carnivore)
            System.out.println(this.getClass().getSimpleName() + " est carnivore");
        else if (herbivore)
            System.out.println(this.getClass().getSimpleName() + " est herbivore");
    }

    public void boire() {
        System.out.println(this.getClass().getSimpleName() + " boit");
    }

}
