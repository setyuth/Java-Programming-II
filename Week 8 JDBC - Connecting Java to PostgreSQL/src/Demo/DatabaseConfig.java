package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {
    // Database credentials (centralized)
    private static final String URL = "jdbc:postgresql://localhost:5432/university_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123";  // Change this!

    /**
     * Get a connection to the database
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✓ Database connection established.");
            return connection;
        } catch (SQLException e) {
            System.out.println("✗ Failed to connect to database!");
            System.out.println("Error: " + e.getMessage());
            throw e;  // Re-throw to let caller handle
        }
    }

    /**
     * Close a connection safely
     * @param connection Connection to close
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("✓ Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    /**
     * Close all resources safely (connection, statement, resultset)
     * @param conn Connection to close
     * @param stmt Statement to close
     * @param rs ResultSet to close
     */
    public static void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        // Close ResultSet
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error closing ResultSet: " + e.getMessage());
            }
        }

        // Close Statement
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error closing Statement: " + e.getMessage());
            }
        }

        // Close Connection
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing Connection: " + e.getMessage());
            }
        }
    }

    /**
     * Test the database connection
     */
    public static void testConnection() {
        try {
            Connection conn = getConnection();
            System.out.println("✓ Database connection test successful!");
            closeConnection(conn);
        } catch (SQLException e) {
            System.out.println("✗ Database connection test failed!");
        }
    }

    public static void main(String[] args) {
        // Test the connection
        testConnection();
    }
}