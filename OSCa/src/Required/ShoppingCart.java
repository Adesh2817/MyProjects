package Required;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addProductToCart(int productId, int quantity) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Query to check if the product exists in the database
            String query = "SELECT * FROM Products WHERE ProductID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int stock = rs.getInt("Stock");
                if (stock >= quantity) {
                    // Add product to the in-memory cartItems list
                    cartItems.add(new CartItem(productId, quantity));
                    System.out.println("Product added to cart!");

                    // Insert product into the Cart table in the database
                    String insertQuery = "INSERT INTO Cart (ProductID, Quantity) VALUES (?, ?)";
                    PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                    insertStmt.setInt(1, productId);
                    insertStmt.setInt(2, quantity);
                    insertStmt.executeUpdate();
                    
                    System.out.println("Product added to the database!");
                } else {
                    System.out.println("Insufficient stock!");
                }
            } else {
                System.out.println("Product not found!");
            }
        }
    }

    public void viewCart() throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Fetch all items from the Cart table
            String query = "SELECT * FROM Cart";  // You can filter by UserID if you need user-based carts
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) { // If no rows are returned
                System.out.println("Your cart is empty!");
            } else {
                System.out.println("Your cart items:");
                while (rs.next()) {
                    int productId = rs.getInt("ProductID"); // Fetch ProductID from the Cart table
                    int quantity = rs.getInt("Quantity");  // Fetch Quantity from the Cart table
                    System.out.println("Product ID: " + productId + ", Quantity: " + quantity);
                }
            }
        }
    }


    public void clearCart() throws Exception {
        // Assuming you want to delete cart items from the database
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Cart WHERE UserID = ?"; // Assuming UserID = 1
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, 1); // Assume userID = 1 for now
            stmt.executeUpdate();
            System.out.println("Cart cleared from database!");
        }
    }
}
