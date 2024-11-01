import java.util.ArrayList;
import java.util.Random;

public class PopulationGenerator {
    ArrayList<Item> population = null;

    public void generatePopulation(ArrayList<Item> availableItems, int populationSize){
        population = new ArrayList<Item>();
        Random random = new Random();

        for (int i=0; i < populationSize; i++){
            Item item = availableItems.get(i);
            int isSelected = random.nextInt(2); // Gera 0 ou 1 (não selecionado ou selecionado)
            if (isSelected == 1){
                population.add(item);
            }
        }
    }

    public ArrayList<Item> getPopulation() {
        return population;
    }
}
