import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InstanceRead instanceRead = new InstanceRead();
        instanceRead.readFile("data/instancias-mochila/KNAPDATA40.txt");

        int populationSize = 100;
        PopulationGenerator populationGenerator = new PopulationGenerator();
        int[][] population = populationGenerator.generatePopulation(instanceRead.getQuantityItems(), populationSize);
        //System.out.println(Arrays.deepToString(population));
        for (int[] i : population){
            System.out.println(Arrays.toString(i));
        }

    }
}