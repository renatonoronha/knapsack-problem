import java.util.Random;

public class Operations {
    CalculateFitness calculateFitness = new CalculateFitness();
    Random random = new Random();

    public int[]  tournamentSelection(int[][] population, Item[] items, int capacity){
        int tournamentSize = 5; // tamanho do torneio
        int[] bestSolution = null; // inicia um vetor de inteiros com o valor null
        double bestFitness = Integer.MIN_VALUE; // inicia a variável com o menor número possível para poder fazer comparações quantitativas

        for (int i=0; i < tournamentSize; i++){
            int[] solution = population[random.nextInt(population.length)]; // seleciona uma solução aleatória da população
            double fitness = calculateFitness.evaluateFitness(solution, items, capacity); // calcula a fitness da solução
            if (fitness > bestFitness){ // se a fitness atual for melhor do que a solução anterior; a soluções estão lutando entre si pra ver qual é a melhor
                bestSolution = solution;
                bestFitness = fitness;
            }
        }
        return bestSolution; // retorna a solução ganhadors (selecionada)
    }

    public int[] roulleteSelection(int[][] population, Item[] items, int capacity){
        double totalFitness = 0;
        double[] cumulativeFitness = new double[population.length]; // cria um vetor do tamanho da população que vai atuar como a "pizza da roleta", com os pedaços representando cada solução
        int selectedIdx = -1; // índice da solução que será selecionada na seleção

        for (int i = 0; i < population.length; i++) {
            double fitness = calculateFitness.evaluateFitness(population[i], items, capacity); // calcula a fitness de cada solução
            totalFitness += fitness; // soma todas as fitnesses
            cumulativeFitness[i] = totalFitness; // adiciona o total atual a posição atual do vetor, esses valores serão considerados as chances da solução ser escolhida
        }

        double randomFitness = random.nextDouble(totalFitness); //nextDouble() vai gerar um número entre 0 e a soma de todas as fitnesses

        // se o número gerado aleatoriamente for menor que a porcentagem atual de chances, a solução atual será escolhida
        // a cada solução não escolhida, é somada a sua fitness (porcentagem de ser escolhida), por exemplo:
        // se essas forem as fitnesses: [10, 15, 30], essa será a pizza que será usada como roleta para selecionar a solução: [10, 25, 55]
        // se o número gerado for: 30, então a primeira solução não será selecionada, porque o número gerado foi 30 e ela só vai de 1 a 10.
        // A segunda solução vai de 11 a 25 então também não será selecionada, por último a terceira solução é a escolhida, pois ela vai de
        // 26 a 55, então 30 estaria dentro de seu range. Isso que eu expliquei atua como as probabilidades das soluções da população
        for (int i = 0; i < population.length; i++) {
            if (randomFitness < cumulativeFitness[i]){
                selectedIdx = i;
                break;
            }
        }

        return population[selectedIdx]; // retorna a solução selecionada
    }

    // Esse método possui um problema: se não cruzar vai retornar um array zerado completamente
    public int[] crossover(int[] parent1, int[] parent2, double crossoverRate){
        int[] offspring = new int[parent1.length]; // filho

        if (random.nextDouble() < crossoverRate){ //nextDouble() vai gerar um número entre 0 e 1
            int crossoverPoint = random.nextInt(parent1.length); // gera o ponto de cruzamento

            for (int i=0; i<parent1.length; i++){

                if (i<crossoverPoint){ // a primeira metade dos genes
                    offspring[i] = parent1[i];

                } else { // a segunda metade dos genes
                    offspring[i] = parent2[i];
                }
            }
        }

        return offspring; // retorna o filho gerado após a probabilidade de cruzamento ser aplicada
    }

    public int[] mutate(int[] solution, double mutationRate){
        for (int item : solution){
            if (random.nextDouble() < mutationRate){ //nextDouble() vai gerar um número entre 0 e 1
                solution[item] = 1 - solution[item]; // Invertendo o bit
            }
        }
        return solution; // retorna a solução selecionada após a probabilidade de mutação ser aplicada
    }
}
