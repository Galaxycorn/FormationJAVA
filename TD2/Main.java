package TD2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Lion lion = new Lion("Orange");
		Tigre tigre = new Tigre("Orang");
		Elephant elephant1 = new Elephant("Gris");
		Elephant elephant2 = new Elephant("Gris");
		Girafe girafe = new Girafe("Orange");
		Ours ours1 = new Ours("Brun");
		Ours ours2 = new Ours("Blanc");
		Ours ours3 = new Ours("Gris");
		Humain humain = new Humain();

		ArrayList<InterfaceCarnivore> carnivores = new ArrayList<>(
				Arrays.asList(lion, tigre, ours1, ours2, ours3, humain));
		ArrayList<InterfaceHerbivore> herbivores = new ArrayList<>(
				Arrays.asList(elephant1, elephant2, girafe, ours1, ours2, ours3, humain));
		ArrayList<Animal> zoo = new ArrayList<>(
				Arrays.asList(elephant1, elephant2, girafe, ours1, ours2, ours3, lion, tigre));

		lion.manger(elephant1);
		ours1.manger(tigre);
		ours1.manger("Miel");

		for (Animal animal : zoo) {
			animal.regime();
		}
	}

}
