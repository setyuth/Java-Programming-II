package com.university.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DatabaseConfig — central place for all database settings.
 *
 * HOW TO USE in other files:
 *   Connection conn = DatabaseConfig.getConnection();
 *   DatabaseConfig.closeResources(conn, pstmt, rs);
 */
public class DatabaseConfig {

    // ── Change PASSWORD to your own PostgreSQL password ──────────────────────
    private static final String URL      = "jdbc:postgresql://localhost:5432/university_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123"; // ⚠️ CHANGE THIS!
    // ────────────────────────────────────────────────────────────────────────

    /**
     * Opens a new connection to university_db.
     * Call this at the start of every database operation.
     * Throws SQLException if connection fails — the caller must handle it.
     */
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("✗ Cannot connect to database: " + e.getMessage());
            System.out.println("  → Is PostgreSQL running?");
            System.out.println("  → Is the password correct in DatabaseConfig.java?");
            System.out.println("  → Does university_db exist in pgAdmin?");
            throw e;
        }
    }

    /**
     * Safely closes all three JDBC resources in the correct order:
     *   ResultSet → Statement → Connection
     *
     * Always call this in your finally block.
     * Pass null for any resource you don't have.
     *
     * Examples:
     *   DatabaseConfig.closeResources(conn, pstmt, rs);   // all three
     *   DatabaseConfig.closeResources(conn, pstmt, null); // no ResultSet
     */
    public static void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try { rs.close(); }
            catch (SQLException e) { System.out.println("Error closing ResultSet: " + e.getMessage()); }
        }
        if (stmt != null) {
            try { stmt.close(); }
            catch (SQLException e) { System.out.println("Error closing Statement: " + e.getMessage()); }
        }
        if (conn != null) {
            try { conn.close(); }
            catch (SQLException e) { System.out.println("Error closing Connection: " + e.getMessage()); }
        }
    }

    /**
     * Run this main() to verify your setup before writing any other code.
     * Expected output: "✓ Connection successful! university_db is ready."
     */
    public static void main(String[] args) {
        System.out.println("Testing database connection to university_db...");
        Connection conn = null;
        try {
            conn = getConnection();
            System.out.println("✓ Connection successful! university_db is ready.");
        } catch (SQLException e) {
            System.out.println("✗ Connection failed. Fix the error above before continuing.");
        } finally {
            closeResources(conn, null, null);
        }
    }
}
