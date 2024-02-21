import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add product");
            System.out.println("2. Display products");
            System.out.println("3. Find product by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    Product product = new Product(productId, productName, price, manufacturer, description);
                    ProductManager.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.println("List of products:");
                    ProductManager.displayProducts();
                    break;

                case 3:
                    System.out.print("Enter product ID to search: ");
                    int searchId = scanner.nextInt();
                    Product foundProduct = ProductManager.findProductById(searchId);
                    if (foundProduct != null) {
                        System.out.println("Found product: " + foundProduct);
                    } else {
                        System.out.println("Product not found with ID: " + searchId);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
