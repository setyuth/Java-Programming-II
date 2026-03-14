package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/university_db";
        String username = "postgres";
        String password = "123";  // Replace with your PostgreSQL password

        Connection connection = null;

        try {
            // Attempt to connect to database
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("✓ Successfully connected to PostgreSQL database!");
            System.out.println("✓ Database: university_db");

        } catch (SQLException e) {
            System.out.println("✗ Connection failed!");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("✓ Connection closed.");
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}