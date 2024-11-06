import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InstanceRead instanceRead = new InstanceRead();
        instanceRead.readFile("data/instancias-mochila/KNAPDATA40.txt");

        CalculateFitness calculateFitness = new CalculateFitness();

        int populationSize = 100;
        double crossoverRate = 0.8;
        double mutationRate = 0.1;
        int numGenerations = 500;

        PopulationGenerator populationGenerator = new PopulationGenerator();
        int[][] population = populationGenerator.generatePopulation(instanceRead.getQuantityItems(), populationSize);
//        for (int[] i : population){
//            System.out.println(calculateFitness.evaluateFitness(i, instanceRead.getItems(), instanceRead.getSupportedWeight()));
//        }

        Operations operations = new Operations();
        int[] a = operations.roulleteSelection(population, instanceRead.getItems(), instanceRead.getSupportedWeight());
        //System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(operations.tournamentSelection(population, instanceRead.getItems(), instanceRead.getSupportedWeight())));
        //System.out.println(Arrays.toString(operations.mutate(a, mutationRate)));


    }
}