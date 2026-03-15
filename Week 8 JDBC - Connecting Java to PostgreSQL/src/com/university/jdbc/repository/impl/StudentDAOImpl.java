package com.university.jdbc.repository.impl;


import com.university.jdbc.config.DatabaseConfig;
import com.university.jdbc.model.Student;
import com.university.jdbc.repository.StudentDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAOImpl — complete SQL implementation of StudentDAO.
 *
 * PATTERN used in every method:
 *   1. Declare Connection, PreparedStatement, ResultSet = null
 *   2. conn = DatabaseConfig.getConnection()
 *   3. Prepare and execute the SQL
 *   4. Process the result
 *   5. ALWAYS close resources in the finally block
 *
 * All SELECT queries JOIN with departments to include department_name.
 */
public class StudentDAOImpl implements StudentDAO {

    // ════════════════════════════════════════════════════════════════════════
    //  CREATE
    // ════════════════════════════════════════════════════════════════════════

    /**
     * INSERT a new student row into the students table.
     *
     * SQL: INSERT INTO students
     *          (student_id, name, age, email, phone, major, gpa, department_id)
     *      VALUES (?, ?, ?, ?, ?, ?, ?, ?)
     *
     * enrollment_date is NOT included — PostgreSQL sets it automatically
     * via DEFAULT CURRENT_DATE defined in theWeek 7 schema.
     */
    @Override
    public boolean addStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "INSERT INTO students " +
                    "(student_id, name, age, email, phone, major, gpa, department_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            // Set each ? in order — index starts at 1, not 0!
            pstmt.setString(1, student.getStudentId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3,    student.getAge());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getPhone());      // nullable — OK to be null
            pstmt.setString(6, student.getMajor());
            pstmt.setDouble(7, student.getGpa());
            pstmt.setInt(8,    student.getDepartmentId());

            // executeUpdate() returns number of rows inserted
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate key")) {
                System.out.println("  ✗ That Student ID already exists.");
            } else if (e.getMessage().contains("violates foreign key")) {
                System.out.println("  ✗ Department ID does not exist in the departments table.");
            } else if (e.getMessage().contains("check constraint")) {
                System.out.println("  ✗ Invalid data: age must be 16–100, GPA must be 0.0–4.0.");
            } else {
                System.out.println("  ✗ Database error: " + e.getMessage());
            }
            return false;

        } finally {
            DatabaseConfig.closeResources(conn, pstmt, null);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  READ
    // ════════════════════════════════════════════════════════════════════════

    /**
     * SELECT one student by student_id.
     * LEFT JOINs with departments to include department_name.
     * Returns a Student object, or null if not found.
     *
     * SQL: SELECT s.*, d.department_name
     *      FROM students s
     *      LEFT JOIN departments d ON s.department_id = d.department_id
     *      WHERE s.student_id = ?
     *
     * LEFT JOIN is used so students with no department assigned still appear.
     */
    @Override
    public Student getStudentById(String studentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "SELECT s.*, d.department_name " +
                    "FROM students s " +
                    "LEFT JOIN departments d ON s.department_id = d.department_id " +
                    "WHERE s.student_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);

            rs = pstmt.executeQuery();   // executeQuery() for SELECT only

            if (rs.next()) {
                return extractStudent(rs);  // convert the row into a Student object
            }
            return null;  // student not found

        } catch (SQLException e) {
            System.out.println("  ✗ Error finding student: " + e.getMessage());
            return null;
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);
        }
    }

    /**
     * SELECT all students with their department names, sorted alphabetically.
     * Returns an empty List (never null) if no students exist.
     *
     * SQL: SELECT s.*, d.department_name
     *      FROM students s
     *      LEFT JOIN departments d ON s.department_id = d.department_id
     *      ORDER BY s.name
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "SELECT s.*, d.department_name " +
                    "FROM students s " +
                    "LEFT JOIN departments d ON s.department_id = d.department_id " +
                    "ORDER BY s.name";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // rs.next() moves to the next row — returns false when all rows are read
            while (rs.next()) {
                students.add(extractStudent(rs));
            }

        } catch (SQLException e) {
            System.out.println("  ✗ Error loading students: " + e.getMessage());
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);
        }

        return students;  // empty list, not null — safer to work with
    }

    /**
     * SELECT students with a specific major, highest GPA first.
     *
     * SQL: SELECT s.*, d.department_name
     *      FROM students s
     *      LEFT JOIN departments d ON s.department_id = d.department_id
     *      WHERE s.major = ?
     *      ORDER BY s.gpa DESC
     */
    @Override
    public List<Student> getStudentsByMajor(String major) {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "SELECT s.*, d.department_name " +
                    "FROM students s " +
                    "LEFT JOIN departments d ON s.department_id = d.department_id " +
                    "WHERE s.major = ? " +
                    "ORDER BY s.gpa DESC";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, major);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                students.add(extractStudent(rs));
            }

        } catch (SQLException e) {
            System.out.println("  ✗ Error finding students by major: " + e.getMessage());
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);
        }

        return students;
    }

    /**
     * SELECT all students belonging to a department, sorted by name.
     * Uses the department_id foreign key from theWeek 7 students table.
     *
     * SQL: SELECT s.*, d.department_name
     *      FROM students s
     *      LEFT JOIN departments d ON s.department_id = d.department_id
     *      WHERE s.department_id = ?
     *      ORDER BY s.name
     */
    @Override
    public List<Student> getStudentsByDepartment(int departmentId) {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "SELECT s.*, d.department_name " +
                    "FROM students s " +
                    "LEFT JOIN departments d ON s.department_id = d.department_id " +
                    "WHERE s.department_id = ? " +
                    "ORDER BY s.name";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, departmentId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                students.add(extractStudent(rs));
            }

        } catch (SQLException e) {
            System.out.println("  ✗ Error finding students by department: " + e.getMessage());
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);
        }

        return students;
    }

    /**
     * SELECT students whose GPA >= minGpa, highest first. Used for Honor Roll.
     *
     * SQL: SELECT s.*, d.department_name
     *      FROM students s
     *      LEFT JOIN departments d ON s.department_id = d.department_id
     *      WHERE s.gpa >= ?
     *      ORDER BY s.gpa DESC
     */
    @Override
    public List<Student> getHonorRollStudents(double minGpa) {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "SELECT s.*, d.department_name " +
                    "FROM students s " +
                    "LEFT JOIN departments d ON s.department_id = d.department_id " +
                    "WHERE s.gpa >= ? " +
                    "ORDER BY s.gpa DESC";

            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, minGpa);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                students.add(extractStudent(rs));
            }

        } catch (SQLException e) {
            System.out.println("  ✗ Error loading honor roll: " + e.getMessage());
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);
        }

        return students;
    }

    // ════════════════════════════════════════════════════════════════════════
    //  UPDATE
    // ════════════════════════════════════════════════════════════════════════

    /**
     * UPDATE all editable fields for an existing student.
     *
     * SQL: UPDATE students
     *      SET name=?, age=?, email=?, phone=?, major=?, gpa=?, department_id=?
     *      WHERE student_id=?
     *
     * ⚠️ The WHERE clause is CRITICAL — without it every row in the table
     *    would be updated at once!
     *
     * Parameter order: SET values first (1–7), then WHERE value (8).
     */
    @Override
    public boolean updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "UPDATE students " +
                    "SET name = ?, age = ?, email = ?, phone = ?, " +
                    "    major = ?, gpa = ?, department_id = ? " +
                    "WHERE student_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setInt(2,    student.getAge());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getPhone());
            pstmt.setString(5, student.getMajor());
            pstmt.setDouble(6, student.getGpa());
            pstmt.setInt(7,    student.getDepartmentId());
            pstmt.setString(8, student.getStudentId());  // WHERE — always the last parameter

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("  ✗ Error updating student: " + e.getMessage());
            return false;
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, null);
        }
    }

    /**
     * UPDATE only the GPA column for one student.
     *
     * SQL: UPDATE students SET gpa = ? WHERE student_id = ?
     */
    @Override
    public boolean updateGPA(String studentId, double newGpa) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "UPDATE students SET gpa = ? WHERE student_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, newGpa);
            pstmt.setString(2, studentId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("  ✗ Error updating GPA: " + e.getMessage());
            return false;
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, null);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  DELETE
    // ════════════════════════════════════════════════════════════════════════

    /**
     * DELETE one student row by student_id.
     *
     * SQL: DELETE FROM students WHERE student_id = ?
     *
     * ⚠️ Always use WHERE — "DELETE FROM students" deletes EVERYONE!
     *
     * TheWeek 7 enrollments table has ON DELETE CASCADE on student_id,
     * so deleting a student also removes their enrollment records automatically.
     */
    @Override
    public boolean deleteStudent(String studentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "DELETE FROM students WHERE student_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("  ✗ Error deleting student: " + e.getMessage());
            return false;
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, null);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  STATISTICS
    // ════════════════════════════════════════════════════════════════════════

    /**
     * COUNT(*) total number of students.
     *
     * SQL: SELECT COUNT(*) AS count FROM students
     */
    @Override
    public int getStudentCount() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();
            String sql = "SELECT COUNT(*) AS count FROM students";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("count");
            }

        } catch (SQLException e) {
            System.out.println("  ✗ Error counting students: " + e.getMessage());
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);
        }

        return 0;
    }

    /**
     * Calculate average GPA (ignoring NULL values).
     *
     * SQL: SELECT AVG(gpa) AS avg_gpa FROM students WHERE gpa IS NOT NULL
     */
    @Override
    public double getAverageGPA() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();
            String sql = "SELECT AVG(gpa) AS avg_gpa FROM students WHERE gpa IS NOT NULL";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("avg_gpa");
            }

        } catch (SQLException e) {
            System.out.println("  ✗ Error calculating average GPA: " + e.getMessage());
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);
        }

        return 0.0;
    }

    // ════════════════════════════════════════════════════════════════════════
    //  PRIVATE HELPER
    // ════════════════════════════════════════════════════════════════════════

    /**
     * Converts the current ResultSet row into a Student object.
     *
     * Called by every read method above — centralising this logic means if a
     * column name changes, we only fix it here, not in five different methods.
     *
     * Reads enrollment_date as a String for simple display.
     * Reads department_name from the LEFT JOIN result.
     */
    private Student extractStudent(ResultSet rs) throws SQLException {
        // enrollment_date may be null for records inserted without a date
        String enrollmentDate = "";
        if (rs.getDate("enrollment_date") != null) {
            enrollmentDate = rs.getDate("enrollment_date").toString();
        }

        return new Student(
                rs.getString("student_id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("email"),
                rs.getString("phone"),           // nullable column
                rs.getString("major"),
                rs.getDouble("gpa"),
                rs.getInt("department_id"),
                enrollmentDate,
                rs.getString("department_name")  // from the LEFT JOIN
        );
    }
}
