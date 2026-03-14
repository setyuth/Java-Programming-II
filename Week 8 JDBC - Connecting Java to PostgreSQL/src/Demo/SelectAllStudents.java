package Demo;

import java.sql.*;

public class SelectAllStudents {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Get database connection
            connection = DatabaseConfig.getConnection();

            // 2. Prepare SQL query
            String sql = "SELECT student_id, name, age, email, major, gpa FROM students ORDER BY name";
            pstmt = connection.prepareStatement(sql);

            // 3. Execute query and get results
            rs = pstmt.executeQuery();

            // 4. Process the ResultSet
            System.out.println("=== All Students ===");
            System.out.printf("%-10s %-20s %-5s %-25s %-20s %-5s\n",
                    "ID", "Name", "Age", "Email", "Major", "GPA");
            System.out.println("-".repeat(90));

            int count = 0;
            while (rs.next()) {
                // Get data from current row
                String id = rs.getString("student_id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String major = rs.getString("major");
                double gpa = rs.getDouble("gpa");

                // Display the data
                System.out.printf("%-10s %-20s %-5d %-25s %-20s %.2f\n",
                        id, name, age, email, major, gpa);
                count++;
            }

            System.out.println("-".repeat(90));
            System.out.println("Total students: " + count);

        } catch (SQLException e) {
            System.out.println("✗ Error executing query!");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 5. Always close resources (important!)
            DatabaseConfig.closeResources(connection, pstmt, rs);
        }
    }
}