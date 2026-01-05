package Homework_Assignment.Course_Management;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   STUDENT MANAGEMENT SYSTEM            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. Add New Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Update Student GPA");
        System.out.println("5. Delete Student");
        System.out.println("6. Display Honor Roll Students");
        System.out.println("7. Manage Student Courses (NEW)");
        System.out.println("8. Exit");
        System.out.println("─────────────────────────────────────────");
        System.out.print("Enter your choice (1-8): ");
    }

    // ... [Previous methods: addStudent, displayAllStudents, searchStudent, etc. remain the same] ...
    // Note: Copied previous methods here for context, ensuring the class is complete.

    public void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        System.out.print("Enter GPA (0.0-4.0): ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        students.add(new Student(id, name, age, major, gpa));
        System.out.println("✓ Student added successfully!");
    }

    public void displayAllStudents() {
        // ... (Same as previous task)
        for (Student s : students) { s.displayInfo(); System.out.println("---"); }
    }

    public void searchStudent() {
        // ... (Same as previous task)
        System.out.print("Search Name: ");
        String name = scanner.nextLine();
        for(Student s : students) if(s.getName().equalsIgnoreCase(name)) s.displayInfo();
    }

    public void updateGPA() {
        // ... (Same as previous task)
        System.out.print("Student Name: ");
        String name = scanner.nextLine();
        for(Student s : students) {
            if(s.getName().equalsIgnoreCase(name)) {
                System.out.print("New GPA: ");
                s.setGpa(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Updated.");
                return;
            }
        }
    }

    public void deleteStudent() {
        // ... (Same as previous task)
        System.out.print("Student Name: ");
        String name = scanner.nextLine();
        students.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }

    public void displayHonorRoll() {
        // ... (Same as previous task)
        for(Student s : students) if(s.isHonorRoll()) s.displayInfo();
    }

    // --- NEW: Course Management Menu ---
    public void manageCourses() {
        System.out.println("\n--- Manage Student Courses ---");
        System.out.print("Enter student name to manage: ");
        String name = scanner.nextLine();

        Student foundStudent = null;
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("✗ Student not found.");
            return;
        }

        // Sub-menu for the specific student
        boolean back = false;
        while (!back) {
            System.out.println("\nManaging Courses for: " + foundStudent.getName());
            System.out.println("1. Enroll in Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Enrolled Courses");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Course Code (e.g. CS101): ");
                    String code = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();

                    Course newCourse = new Course(code, cName, credits);
                    foundStudent.enrollCourse(newCourse);
                    break;
                case 2:
                    System.out.print("Enter Course Code to Drop: ");
                    String dropCode = scanner.nextLine();
                    foundStudent.dropCourse(dropCode);
                    break;
                case 3:
                    foundStudent.displayEnrolledCourses();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void run() {
        System.out.println("Welcome to Student Management System!");
        int choice;
        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAllStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateGPA(); break;
                case 5: deleteStudent(); break;
                case 6: displayHonorRoll(); break;
                case 7: manageCourses(); break; // New Option
                case 8: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}
