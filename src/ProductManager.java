import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final String FILE_NAME = "products.dat";

    public static void addProduct(Product product) {
        List<Product> products = readProducts();
        products.add(product);
        writeProducts(products);
    }

    public static List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(FILE_NAME)))) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Ignore if the file doesn't exist or cannot be read
        }
        return products;
    }

    public static void writeProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(FILE_NAME)))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayProducts() {
        List<Product> products = readProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Product findProductById(int productId) {
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

