import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Order {

    private static int count;
    private final int id;
    private Client client;
    private Product product;
    private int qnt;


    static {
        count = 0;
    }
    public Order(Client client, Product product, int qnt) {
        this.client = client;
        this.product = product;
        this.qnt = qnt;
        this.id = count++;
    }

    public String getClientName() {
        return client.toString();
    }

    public String getProduct() {
        return product.toString();
    }

    public int getQnt() {
        return qnt;
    }

    public double getPrice() {
        return product.getPrice();
    }

    public int getId() {
        return id;
    }

    public void saveToJson() {
        String fileName = "order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"client firstName\":\""+ client.getFirstName() + "\",\n");
            writer.write("\"client lastName\":\""+ client.getLastName() + "\",\n");
            writer.write("\"client phoneNumber\":\""+ client.getPhoneNumber() + "\",\n");
            writer.write("\"product brand\":\""+product.getBrand()+"\",\n");
            writer.write("\"product brand\":\""+product.getName()+"\",\n");
            writer.write("\"product price\":"+product.getPrice()+"\n");
            writer.write("\"qnt\":"+qnt+",\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void inputFromConsole(){
        client.setFirstName(prompt("Client firstname: "));
        client.setLastName(prompt("Client lastname: "));
        client.setPhoneNumber(prompt("Phone number: "));

        product.setBrand(prompt("Brand name: "));
        product.setName(prompt("Product name: "));
        product.setPrice(Integer.parseInt(prompt("Price: ")));

        qnt = Integer.parseInt(prompt("Quantity: "));
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}