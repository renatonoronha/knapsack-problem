import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InstanceRead instanceRead = new InstanceRead();
        instanceRead.readFile("data/instancias-mochila/KNAPDATA40.txt");


        int populationSize = 100;
        double crossoverRate = 0.8;
        double mutationRate = 0.1;
        int numGenerations = 500;

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        int[] solution = geneticAlgorithm.geneticAlgorithmKnapsack(instanceRead.getItems(),
                instanceRead.getSupportedWeight(), populationSize, crossoverRate, mutationRate, numGenerations);

        System.out.println("Itens selecionados: ");
        for (int i = 0; i < instanceRead.getQuantityItems(); i++) {
            if (solution[i] == 1) {
                System.out.println("Item " + (i+1) +
                        " Peso: " + instanceRead.getItems()[i].getWeight() +
                        " Valor: " + instanceRead.getItems()[i].getValue());
            }
        }
    }
}