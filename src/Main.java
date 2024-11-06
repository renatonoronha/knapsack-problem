import core.GeneticAlgorithm;
import utils.InstanceReader;

public class Main {
    public static void main(String[] args) {
        InstanceReader instanceReader = new InstanceReader();
        instanceReader.readFile("data/instancias-mochila/KNAPDATA100.TXT");

        int populationSize = 100;
        double crossoverRate = 0.8;
        double mutationRate = 0.1;
        int numGenerations = 500;

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        int[] solution = geneticAlgorithm.runKnapsack(instanceReader.getItems(),
                instanceReader.getSupportedWeight(),
                populationSize, crossoverRate,
                mutationRate, numGenerations);

        System.out.println("Itens selecionados: ");
        for (int i = 0; i < instanceReader.getQuantityItems(); i++) {
            if (solution[i] == 1) {
                System.out.println(
                        "model.Item " + (i+1) +
                        " Peso: " + instanceReader.getItems()[i].getWeight() +
                        " Valor: " + instanceReader.getItems()[i].getValue());
            }
        }
    }
}