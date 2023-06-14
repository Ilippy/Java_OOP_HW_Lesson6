public class Main {
    public static void main(String[] args) {
        System.out.println("Введите заказ:");
        Client client = new Client("Илья", "Куликовский", "89651234567");
        Product product = new Product("Apple", "IPhone14 pro", 120_000.00);
        Order order = new Order(client, product, 1);
        order.saveToJson();
        order.inputFromConsole();
    }
}