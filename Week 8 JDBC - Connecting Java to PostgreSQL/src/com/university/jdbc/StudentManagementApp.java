package com.university.jdbc;

import com.university.jdbc.config.DatabaseConfig;
import com.university.jdbc.model.Student;
import com.university.jdbc.repository.StudentDAO;
import com.university.jdbc.repository.impl.StudentDAOImpl;

import java.util.List;
import java.util.Scanner;

/**
 * StudentManagementApp — the console menu application.
 *
 * Responsibilities of this file:
 *   ✅ Display the menu
 *   ✅ Read user input from the keyboard
 *   ✅ Call StudentDAO methods
 *   ✅ Display results to the user
 *
 *   ❌ No SQL code here — all database work is in StudentDAOImpl
 *
 * This separation is the DAO pattern in action.
 */
public class StudentManagementApp {

    private StudentDAO studentDAO;
    private Scanner    scanner;

    public StudentManagementApp() {
        this.studentDAO = new StudentDAOImpl();
        this.scanner    = new Scanner(System.in);
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MENU
    // ════════════════════════════════════════════════════════════════════════

    public void displayMenu() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║    STUDENT MANAGEMENT SYSTEM  (JDBC)     ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1.  Add New Student                     ║");
        System.out.println("║  2.  View All Students                   ║");
        System.out.println("║  3.  Find Student by ID                  ║");
        System.out.println("║  4.  Find Students by Major              ║");
        System.out.println("║  5.  Find Students by Department         ║");
        System.out.println("║  6.  View Honor Roll  (GPA >= 3.5)       ║");
        System.out.println("║  7.  Update Student GPA                  ║");
        System.out.println("║  8.  Update Student Information          ║");
        System.out.println("║  9.  Delete Student                      ║");
        System.out.println("║  10. View Statistics                     ║");
        System.out.println("║  11. Exit                                ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("  Enter your choice (1–11): ");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 1 — Add New Student
    // ════════════════════════════════════════════════════════════════════════

    public void addStudent() {
        System.out.println("\n── Add New Student ──────────────────────────");

        try {
            System.out.print("  Student ID   (e.g. S009) : ");
            String id = scanner.nextLine().trim();

            System.out.print("  Full Name               : ");
            String name = scanner.nextLine().trim();

            System.out.print("  Age                     : ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("  Email                   : ");
            String email = scanner.nextLine().trim();

            System.out.print("  Phone (press Enter to skip): ");
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) phone = null;  // phone is nullable in schema

            System.out.print("  Major                   : ");
            String major = scanner.nextLine().trim();

            System.out.print("  GPA (0.0–4.0)           : ");
            double gpa = Double.parseDouble(scanner.nextLine().trim());

            System.out.println("  Departments: 1=Computer Science  2=Mathematics");
            System.out.println("               3=Physics  4=Chemistry  5=Engineering");
            System.out.print("  Department ID (1–5)     : ");
            int deptId = Integer.parseInt(scanner.nextLine().trim());

            // Validate before hitting the database
            if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                System.out.println("  ✗ Student ID, Name, and Email cannot be empty.");
                return;
            }
            if (gpa < 0.0 || gpa > 4.0) {
                System.out.println("  ✗ GPA must be between 0.0 and 4.0.");
                return;
            }
            if (age < 16 || age > 100) {
                System.out.println("  ✗ Age must be between 16 and 100 (Week 6 constraint).");
                return;
            }
            if (deptId < 1 || deptId > 5) {
                System.out.println("  ✗ Department ID must be 1 to 5.");
                return;
            }

            // Use the 8-field constructor — enrollment_date set by PostgreSQL DEFAULT
            Student student = new Student(id, name, age, email, phone, major, gpa, deptId);

            if (studentDAO.addStudent(student)) {
                System.out.println("  ✓ Student added successfully!");
            } else {
                System.out.println("  ✗ Failed to add student. See error above.");
            }

        } catch (NumberFormatException e) {
            System.out.println("  ✗ Invalid number entered — please try again.");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 2 — View All Students
    // ════════════════════════════════════════════════════════════════════════

    public void viewAllStudents() {
        System.out.println("\n── All Students ─────────────────────────────");
        List<Student> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("  No students found.");
            return;
        }

        System.out.printf("  %-6s  %-15s  %-4s  %-25s  %-20s  %-4s  %s%n",
                "ID", "Name", "Age", "Email", "Major", "GPA", "Department");
        System.out.println("  " + "─".repeat(105));

        for (Student s : students) {
            System.out.printf("  %-6s  %-15s  %-4d  %-25s  %-20s  %.2f  %s%n",
                    s.getStudentId(), s.getName(), s.getAge(), s.getEmail(),
                    s.getMajor(), s.getGpa(),
                    (s.getDepartmentName() != null ? s.getDepartmentName() : "-"));
        }

        System.out.println("  " + "─".repeat(105));
        System.out.println("  Total: " + students.size() + " student(s)");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 3 — Find by ID
    // ════════════════════════════════════════════════════════════════════════

    public void findStudentById() {
        System.out.println("\n── Find Student by ID ───────────────────────");
        System.out.print("  Enter Student ID: ");
        String id = scanner.nextLine().trim();

        Student student = studentDAO.getStudentById(id);

        if (student != null) {
            System.out.println("  ✓ Student found:");
            printStudentCard(student);
        } else {
            System.out.println("  ✗ No student found with ID: " + id);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 4 — Find by Major
    // ════════════════════════════════════════════════════════════════════════

    public void findStudentsByMajor() {
        System.out.println("\n── Find Students by Major ───────────────────");
        System.out.print("  Enter Major (e.g. Computer Science): ");
        String major = scanner.nextLine().trim();

        List<Student> students = studentDAO.getStudentsByMajor(major);

        if (students.isEmpty()) {
            System.out.println("  No students found in major: " + major);
        } else {
            System.out.println("  Students in " + major + " (highest GPA first):");
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                System.out.printf("  %d. %-15s  GPA: %.2f  Dept: %s%n",
                        i + 1, s.getName(), s.getGpa(),
                        (s.getDepartmentName() != null ? s.getDepartmentName() : "-"));
            }
            System.out.println("  Total: " + students.size() + " student(s)");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 5 — Find by Department
    // ════════════════════════════════════════════════════════════════════════

    public void findStudentsByDepartment() {
        System.out.println("\n── Find Students by Department ──────────────");
        System.out.println("  Departments: 1=Computer Science  2=Mathematics");
        System.out.println("               3=Physics  4=Chemistry  5=Engineering");
        System.out.print("  Enter Department ID (1–5): ");

        try {
            int deptId = Integer.parseInt(scanner.nextLine().trim());
            List<Student> students = studentDAO.getStudentsByDepartment(deptId);

            if (students.isEmpty()) {
                System.out.println("  No students found in department ID: " + deptId);
            } else {
                String deptName = students.get(0).getDepartmentName();
                System.out.println("  Students in " + deptName + ":");
                for (int i = 0; i < students.size(); i++) {
                    Student s = students.get(i);
                    System.out.printf("  %d. %-15s  Major: %-20s  GPA: %.2f%n",
                            i + 1, s.getName(), s.getMajor(), s.getGpa());
                }
                System.out.println("  Total: " + students.size() + " student(s)");
            }
        } catch (NumberFormatException e) {
            System.out.println("  ✗ Please enter a number (1–5).");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 6 — Honor Roll
    // ════════════════════════════════════════════════════════════════════════

    public void viewHonorRoll() {
        System.out.println("\n── Honor Roll  (GPA >= 3.5) ─────────────────");
        List<Student> students = studentDAO.getHonorRollStudents(3.5);

        if (students.isEmpty()) {
            System.out.println("  No students currently on the honor roll.");
        } else {
            System.out.printf("  %-4s  %-15s  %-20s  %-22s  %s%n",
                    "Rank", "Name", "Major", "Department", "GPA");
            System.out.println("  " + "─".repeat(75));
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                System.out.printf("  %-4d  %-15s  %-20s  %-22s  %.2f%n",
                        i + 1, s.getName(), s.getMajor(),
                        (s.getDepartmentName() != null ? s.getDepartmentName() : "-"),
                        s.getGpa());
            }
            System.out.println("  Total: " + students.size() + " student(s) on honor roll");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 7 — Update GPA
    // ════════════════════════════════════════════════════════════════════════

    public void updateGPA() {
        System.out.println("\n── Update Student GPA ───────────────────────");
        System.out.print("  Enter Student ID: ");
        String id = scanner.nextLine().trim();

        Student student = studentDAO.getStudentById(id);
        if (student == null) {
            System.out.println("  ✗ No student found with ID: " + id);
            return;
        }

        System.out.println("  Student: " + student.getName());
        System.out.printf("  Current GPA: %.2f%n", student.getGpa());
        System.out.print("  New GPA (0.0–4.0): ");

        try {
            double newGpa = Double.parseDouble(scanner.nextLine().trim());

            if (newGpa < 0.0 || newGpa > 4.0) {
                System.out.println("  ✗ GPA must be between 0.0 and 4.0.");
                return;
            }

            if (studentDAO.updateGPA(id, newGpa)) {
                System.out.printf("  ✓ GPA updated: %.2f → %.2f%n", student.getGpa(), newGpa);
            } else {
                System.out.println("  ✗ Update failed.");
            }

        } catch (NumberFormatException e) {
            System.out.println("  ✗ Invalid number — enter a decimal like 3.75");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 8 — Update Student Information
    // ════════════════════════════════════════════════════════════════════════

    public void updateStudentInfo() {
        System.out.println("\n── Update Student Information ───────────────");
        System.out.print("  Enter Student ID: ");
        String id = scanner.nextLine().trim();

        Student student = studentDAO.getStudentById(id);
        if (student == null) {
            System.out.println("  ✗ No student found with ID: " + id);
            return;
        }

        System.out.println("  Current information:");
        printStudentCard(student);
        System.out.println("  Press Enter to keep the current value for any field.\n");

        System.out.print("  Name  [" + student.getName() + "]: ");
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) student.setName(input);

        System.out.print("  Age   [" + student.getAge() + "]: ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            try { student.setAge(Integer.parseInt(input)); }
            catch (NumberFormatException e) { System.out.println("  (Invalid age — keeping current)"); }
        }

        System.out.print("  Email [" + student.getEmail() + "]: ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) student.setEmail(input);

        System.out.print("  Phone [" + (student.getPhone() != null ? student.getPhone() : "") + "]: ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) student.setPhone(input);

        System.out.print("  Major [" + student.getMajor() + "]: ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) student.setMajor(input);

        System.out.print("  GPA   [" + student.getGpa() + "]: ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            try { student.setGpa(Double.parseDouble(input)); }
            catch (NumberFormatException e) { System.out.println("  (Invalid GPA — keeping current)"); }
        }

        System.out.println("  Departments: 1=Computer Science  2=Mathematics  3=Physics  4=Chemistry  5=Engineering");
        System.out.print("  Dept ID [" + student.getDepartmentId() + "]: ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            try { student.setDepartmentId(Integer.parseInt(input)); }
            catch (NumberFormatException e) { System.out.println("  (Invalid department — keeping current)"); }
        }

        if (studentDAO.updateStudent(student)) {
            System.out.println("  ✓ Student information updated successfully!");
        } else {
            System.out.println("  ✗ Update failed.");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 9 — Delete Student
    // ════════════════════════════════════════════════════════════════════════

    public void deleteStudent() {
        System.out.println("\n── Delete Student ───────────────────────────");
        System.out.print("  Enter Student ID: ");
        String id = scanner.nextLine().trim();

        Student student = studentDAO.getStudentById(id);
        if (student == null) {
            System.out.println("  ✗ No student found with ID: " + id);
            return;
        }

        System.out.println("  You are about to delete:");
        printStudentCard(student);
        System.out.println("  ⚠️  Their enrollment records will also be deleted (ON DELETE CASCADE).");
        System.out.print("  Type 'yes' to confirm: ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {
            if (studentDAO.deleteStudent(id)) {
                System.out.println("  ✓ Student and their enrollment records deleted.");
            } else {
                System.out.println("  ✗ Deletion failed.");
            }
        } else {
            System.out.println("  Deletion cancelled — no changes were made.");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  OPTION 10 — Statistics
    // ════════════════════════════════════════════════════════════════════════

    public void viewStatistics() {
        System.out.println("\n── System Statistics ────────────────────────");

        int    total      = studentDAO.getStudentCount();
        double avgGpa     = studentDAO.getAverageGPA();
        int    honorCount = studentDAO.getHonorRollStudents(3.5).size();

        System.out.println("  Total students      : " + total);
        System.out.printf("  Average GPA         : %.2f%n", avgGpa);
        System.out.println("  On honor roll       : " + honorCount + "  (GPA ≥ 3.5)");

        if (total > 0) {
            System.out.printf("  Honor roll %%        : %.1f%%%n",
                    (honorCount * 100.0) / total);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  PRIVATE HELPER — formatted student detail card
    // ════════════════════════════════════════════════════════════════════════

    private void printStudentCard(Student s) {
        System.out.println("  ┌────────────────────────────────────────────┐");
        System.out.printf("  │  ID            : %-27s│%n", s.getStudentId());
        System.out.printf("  │  Name          : %-27s│%n", s.getName());
        System.out.printf("  │  Age           : %-27d│%n", s.getAge());
        System.out.printf("  │  Email         : %-27s│%n", s.getEmail());
        System.out.printf("  │  Phone         : %-27s│%n",
                (s.getPhone() != null ? s.getPhone() : "—"));
        System.out.printf("  │  Major         : %-27s│%n", s.getMajor());
        System.out.printf("  │  GPA           : %-27.2f│%n", s.getGpa());
        System.out.printf("  │  Department    : %-27s│%n",
                (s.getDepartmentName() != null ? s.getDepartmentName()
                        : "dept_id=" + s.getDepartmentId()));
        System.out.printf("  │  Enrolled      : %-27s│%n",
                (s.getEnrollmentDate() != null && !s.getEnrollmentDate().isEmpty()
                        ? s.getEnrollmentDate() : "—"));
        System.out.println("  └────────────────────────────────────────────┘");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  RUN — main application loop
    // ════════════════════════════════════════════════════════════════════════

    public void run() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Welcome to Student Management System   ║");
        System.out.println("║     Connected to: university_db (JDBC)   ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // Verify the database is reachable before showing the menu
        try {
            DatabaseConfig.getConnection().close();
            System.out.println("✓ Connected to university_db successfully!\n");
        } catch (Exception e) {
            System.out.println("✗ Cannot connect to database!");
            System.out.println("  Fix DatabaseConfig.java then restart.\n");
            return;
        }

        int choice;
        do {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:  addStudent();               break;
                    case 2:  viewAllStudents();          break;
                    case 3:  findStudentById();          break;
                    case 4:  findStudentsByMajor();      break;
                    case 5:  findStudentsByDepartment(); break;
                    case 6:  viewHonorRoll();            break;
                    case 7:  updateGPA();                break;
                    case 8:  updateStudentInfo();        break;
                    case 9:  deleteStudent();            break;
                    case 10: viewStatistics();           break;
                    case 11:
                        System.out.println("\n  Goodbye! Connection closed.");
                        break;
                    default:
                        System.out.println("  ✗ Enter a number from 1 to 11.");
                }
            } catch (NumberFormatException e) {
                System.out.println("  ✗ Invalid input — please type a number.");
                choice = 0;
            }
        } while (choice != 11);

        scanner.close();
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MAIN — entry point for the whole application
    // ════════════════════════════════════════════════════════════════════════

    public static void main(String[] args) {
        new StudentManagementApp().run();
    }
}
