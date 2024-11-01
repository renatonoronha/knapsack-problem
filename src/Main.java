public class Main {
    public static void main(String[] args) {
        InstanceRead instanceRead = new InstanceRead();
        instanceRead.readFile("data/instancias-mochila/KNAPDATA40.txt");

        for (Item item : instanceRead.getItems()) {
            System.out.println("Name:" + item.getName());
            System.out.println("Vaue:" + item.getValue());
            System.out.println("Weight:" + item.getWeight());
            System.out.println();
        }

    }
}