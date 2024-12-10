package Required;

import Required.ShoppingCart;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Clear Cart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Product ID: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        cart.addProductToCart(productId, quantity);
                        break;
                    case 2:
                        cart.viewCart();
                        break;
                    case 3:
                        cart.clearCart();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Database error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        } while (choice != 4);

        scanner.close();
    }
}
