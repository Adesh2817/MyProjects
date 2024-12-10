package Required;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/shopcart";
    private static final String USER = "root";
    private static final String PASSWORD = "Adesh017@";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
