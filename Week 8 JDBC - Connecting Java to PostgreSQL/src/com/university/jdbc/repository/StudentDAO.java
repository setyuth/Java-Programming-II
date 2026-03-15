package com.university.jdbc.repository;

import com.university.jdbc.model.Student;

import java.util.List;

/**
 * StudentDAO — interface (contract) for all student database operations.
 *
 * Why use an interface?
 *   - Clearly documents every operation the system can perform
 *   - Forces a clean structure on StudentDAOImpl
 *   - Makes testing easier — you can swap out the implementation
 *   - This is the DAO (Data Access Object) design pattern
 */
public interface StudentDAO {

    // ── CREATE ───────────────────────────────────────────────────────────────

    /** Add a new student row. Returns true if successful. */
    boolean addStudent(Student student);

    // ── READ ─────────────────────────────────────────────────────────────────

    /** Find one student by ID. Includes department name via JOIN. Returns null if not found. */
    Student getStudentById(String studentId);

    /** Get all students with their department names, sorted by name. */
    List<Student> getAllStudents();

    /** Get all students in a specific major, sorted by GPA highest first. */
    List<Student> getStudentsByMajor(String major);

    /** Get all students belonging to a department, sorted by name. */
    List<Student> getStudentsByDepartment(int departmentId);

    /** Get all students with GPA >= minGpa (honor roll), sorted by GPA highest first. */
    List<Student> getHonorRollStudents(double minGpa);

    // ── UPDATE ───────────────────────────────────────────────────────────────

    /** Update all editable fields of a student. Returns true if successful. */
    boolean updateStudent(Student student);

    /** Update only the GPA for a student. Returns true if successful. */
    boolean updateGPA(String studentId, double newGpa);

    // ── DELETE ───────────────────────────────────────────────────────────────

    /** Delete a student by ID (cascades to enrollments). Returns true if successful. */
    boolean deleteStudent(String studentId);

    // ── STATISTICS ───────────────────────────────────────────────────────────

    /** Count total number of students. */
    int getStudentCount();

    /** Calculate the average GPA across all students. */
    double getAverageGPA();
}
