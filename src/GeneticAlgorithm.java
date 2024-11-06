import java.util.Random;

public class GeneticAlgorithm {
    Random random = new Random();
    PopulationGenerator populationGenerator = new PopulationGenerator();
    Operations operations = new Operations();
    CalculateFitness calculateFitness = new CalculateFitness();

    // Função para implementar o algoritmo genético para o problema da mochila
    public int[] geneticAlgorithmKnapsack(Item[] items, int capacity, int populationSize,
                                         double crossoverRate, double mutationRate, int numGenerations)
    {
        int[][] population = populationGenerator.generatePopulation(items.length, populationSize);

        for (int gen = 0; gen < numGenerations; gen++) {
            int[][] nextGeneration = new int[populationSize][items.length];

            for (int i = 0; i < populationSize; i++) {
                int[] parent1 = operations.tournamentSelection(population, items, capacity);
                int[] parent2 = operations.roulleteSelection(population, items, capacity);
                int[] offspring = operations.crossover(parent1, parent2, crossoverRate);
                operations.mutate(offspring, mutationRate);
                nextGeneration[i] = offspring;
            }
            population = nextGeneration;
        }

        // Encontrar a melhor solução na última geração
        int[] bestSolution = population[0];
        double bestFitness = calculateFitness.evaluateFitness(population[0], items, capacity);
        for (int i = 0; i < populationSize; i++) {
            double fitness = calculateFitness.evaluateFitness(population[i], items, capacity);
            if (fitness > bestFitness) {
                bestSolution = population[i];
                bestFitness = fitness;
            }
        }
        return bestSolution;
    }
}
