import java.util.Scanner;

public abstract class Services {
    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public static Client getClientFromConsole(Client client){
        String clientFirstName = prompt("Client firstname: ");
        String clientLastName = prompt("Client lastname: ");
        String clientPhoneNumber = prompt("Phone number: ");

        if(client != null) {
            client.setFirstName(clientFirstName);
            client.setLastName(clientLastName);
            client.setPhoneNumber(clientPhoneNumber);
        } else
            client = new Client(clientFirstName, clientLastName, clientPhoneNumber);
        return client;
    }

    public static Product getProductFromConsole(Product product){
        String productBrand = prompt("Brand name: ");
        String productName = prompt("Product name: ");
        double productPrice = Double.parseDouble(prompt("Price: "));

        if(product != null) {
            product.setBrand(productBrand);
            product.setName(productName);
            product.setPrice(productPrice);
        } else
            product = new Product(productBrand, productName, productPrice);
        return product;
    }

    public static int getQuantity(){
        return Integer.parseInt(prompt("Quantity: "));
    }

}
