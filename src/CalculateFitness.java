import java.util.ArrayList;

public class CalculateFitness {

    public double evaluateFitness(int[] solution, Item[] items, int capacity){

        double totalValue = 0;
        int totalWeight = 0;
        // Como eu quero associar o item levado ao item da mesma posição, se eu usasse o foreach eu perccorreria 0s e 1s e não conseguiria saber a qual item estou me referindo
        for (int i=0; i < solution.length; i++){ // Percorrendo a solução
            if (solution[i]==1){ // Se o item foi levado
                totalValue += items[i].getValue();
                totalWeight += items[i].getWeight();
            }
        }

        if (totalWeight > capacity){
            double excessRatio = (double) totalWeight / capacity;
            totalValue = totalValue / (excessRatio * excessRatio);
        }
        return totalValue;
    }
}
