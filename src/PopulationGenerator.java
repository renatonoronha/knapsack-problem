import java.util.ArrayList;
import java.util.Random;

public class PopulationGenerator {

    public int[][] generatePopulation(int size, int populationSize){
        int[][] population = new int[populationSize][size]; // Gera um array bidimensional, populationSize representa o tamanho da população de soluções (número de cromossomos) e size representa o número de genes de cada solução (o número de itens totais, contando os que você vai levar e os que não vai levar)
        Random random = new Random();

        for (int i=0; i < populationSize; i++){ // Iterando sobre o número da população de soluções
            for (int j=0; j < size; j++){ // Iterando sobre o número de itens da solução
                population[i][j] = random.nextInt(2); // Gera 0 ou 1 (não selecionado ou selecionado)
            }
        }
        return population;
    }

}
