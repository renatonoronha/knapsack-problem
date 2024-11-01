public class Main {
    public static void main(String[] args) {
        InstanceRead instanceRead = new InstanceRead();
        instanceRead.readFile("data/instancias-mochila/KNAPDATA40.txt");

        PopulationGenerator populationGenerator = new PopulationGenerator();
        populationGenerator.generatePopulation(instanceRead.getItems(), instanceRead.getQuantityItems());
        for (Item item : populationGenerator.getPopulation()){
            System.out.println("Name: " + item.getName());
            System.out.println("Weight: " + item.getWeight());
            System.out.println("Value: " + item.getValue());
            System.out.println();
        }
        System.out.println(populationGenerator.getPopulation());
    }
}