package core;

import model.Item;

public class GeneticAlgorithm {

    private final Population population = new Population();
    private final GeneticOperations geneticOperations = new GeneticOperations();
    private final Fitness fitness = new Fitness();

    // Função para implementar o algoritmo genético para o problema da mochila
    public int[] runKnapsack(Item[] items, int capacity, int populationSize,
                                          double crossoverRate, double mutationRate, int numGenerations)
    {
        int[][] population = this.population.generatePopulation(items.length, populationSize); // this.population se refere ao objeto da classe Population instanciada nessa classe, não da variável desse método

        for (int gen = 0; gen < numGenerations; gen++) {
            int[][] nextGeneration = new int[populationSize][items.length];

            for (int i = 0; i < populationSize; i++) {
                int[] parent1 = geneticOperations.tournamentSelection(population, items, capacity);
                int[] parent2 = geneticOperations.roulleteSelection(population, items, capacity);
                int[] offspring = geneticOperations.crossover(parent1, parent2, crossoverRate);
                geneticOperations.mutate(offspring, mutationRate);
                nextGeneration[i] = offspring;
            }
            population = nextGeneration;
        }

        // Encontrar a melhor solução na última geração
        int[] bestSolution = population[0];
        double bestFitness = this.fitness.evaluateFitness(population[0], items, capacity);
        for (int i = 0; i < populationSize; i++) {
            double fitness = this.fitness.evaluateFitness(population[i], items, capacity);
            if (fitness > bestFitness) {
                bestSolution = population[i];
                bestFitness = fitness;
            }
        }
        return bestSolution;
    }
}
