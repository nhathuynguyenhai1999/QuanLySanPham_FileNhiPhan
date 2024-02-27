import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ProductManager {
    private String FILE_NAME = "product.csv";
    public ProductManager(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            this.FILE_NAME = fileName;
        }
    }
    public void addProduct(Product product) {
        List<Product> products = readProducts();
        products.add(product);
        writeProducts(products);
    }

    public List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int productId = Integer.parseInt(parts[0]);
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                String manufacturer = parts[3];
                String description = parts[4];
                int quantity = Integer.parseInt(parts[5]);
                String type = parts[6];
                products.add(new Product(productId, productName, price, manufacturer, description, quantity, type));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME);
        }
        return products;
    }

    public void writeProducts(List<Product> products) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Product product : products) {
                writer.println(product.getProductId() + "," + product.getProductName() + "," +
                        product.getPrice() + "," + product.getManufacturer() + "," +
                        product.getDescription() + "," + product.getQuantity() + "," + product.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayProducts() {
        List<Product> products = readProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public Product findProductById(int productId) {
        List<Product> products = readProducts();
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
    // Other methods for searching, editing, etc.
}



