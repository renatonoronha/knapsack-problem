import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InstanceRead {
    private int supportedWeight = 0;
    private int quantityItems = 0;
    private ArrayList<Item> items = null; // [Nome do elemento, Peso do elemento, Benefício do elemento]

    public void readFile(String path){
        File file = new File(path); // Criando o objeto pra identificar o arquivo com os dados
        Scanner scanner = null;

        try {
            items = new ArrayList<Item>(); // Criando o array que armazenará os itens
            scanner = new Scanner(file); // Criando o objeto pra ler o arquivo

            // 1a linha - Peso suportado pela mochila
            supportedWeight = Integer.parseInt(scanner.nextLine());

            // 2a linha - Quantidade de itens disponíveis
            quantityItems = Integer.parseInt(scanner.nextLine());

            // Iterando sobre os itens disponíveis - [Nome, Peso, Benefício]
            while (scanner.hasNextLine()) {
                String[] element = scanner.nextLine().strip().split(","); // Pega a linha do arquivo (String única) e transforma em um array com os atributos do item e insere no array de Strings element
                Item item = new Item(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2])); // Instancia um novo objeto da classe Item usando os elementos(atributos) do array element
                items.add(item); // adiciona o objeto da classe Item no ArrayList dos Itens
            }

        // Exceção lançada caso o caminho passado como argumento não exista
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());

        // Após concluir a operação
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

    public int getSupportedWeight() {
        return supportedWeight;
    }

    public int getQuantityItems() {
        return quantityItems;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
