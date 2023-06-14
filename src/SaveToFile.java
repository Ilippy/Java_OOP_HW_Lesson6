import java.io.FileWriter;
import java.io.IOException;

public abstract class SaveToFile {
    public static void saveToJson(Order order) {
        String fileName = "order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            Client client = order.getClient();
            Product product = order.getProduct();
            writer.write("{\n");
            writer.write("\"client firstName\":\"" + client.getFirstName() + "\",\n");
            writer.write("\"client lastName\":\"" + client.getLastName() + "\",\n");
            writer.write("\"client phoneNumber\":\"" + client.getPhoneNumber() + "\",\n");
            writer.write("\"product brand\":\"" + product.getBrand() + "\",\n");
            writer.write("\"product name\":\"" + product.getName() + "\",\n");
            writer.write("\"product price\":" + product.getPrice() + ",\n");
            writer.write("\"qnt\":" + order.getQnt() + "\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
