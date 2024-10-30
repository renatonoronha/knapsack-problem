import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InstanceRead {

    public void readFile(String path){
        File file = new File(path);
        Scanner scanner = null;
        ArrayList<String> items = new ArrayList<String>(); // [Nome do elemento, Peso do elemento, Benefício do elemento]

        try {
            scanner = new Scanner(file);

            // Peso suportado pela mochila
            String supported_weight_str = scanner.nextLine();
            int supported_weight = Integer.parseInt(supported_weight_str);

            // Quantidade de itens disponíveis
            String quantity_items_str = scanner.nextLine();
            int quantity_items = Integer.parseInt(quantity_items_str);

            // Iterando sobre os itens disponíveis
            while (scanner.hasNextLine()) {
                String item = Arrays.toString(scanner.nextLine().strip().split(","));
                items.add(item);
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
}
