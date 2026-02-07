package HANDS_ON_PROJECT;

import HANDS_ON_PROJECT.Exception.InvalidDataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;

public class PersistentUniversitySystem {
    private HashMap<String, Student> studentsById;
    private ArrayList<Student> students;
    private Scanner scanner;

    public PersistentUniversitySystem() {
        studentsById = new HashMap<>();
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadData();
    }

    private void loadData() {
        System.out.println("Loading data from file...");
        students = FileManager.loadStudents();

        // Rebuild HashMap
        for (Student student : students) {
            studentsById.put(student.getId(), student);
        }
    }

    private void saveData() {
        try {
            FileManager.saveStudents(students);
        } catch (IOException e) {
            System.out.println("Failed to save data!");
        }
    }

    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   STUDENT MANAGEMENT SYSTEM v2.0       ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1.  Add Student");
        System.out.println("2.  Display All Students");
        System.out.println("3.  Search Student");
        System.out.println("4.  Update Student GPA");
        System.out.println("5.  Delete Student");
        System.out.println("6.  Display Honor Roll");
        System.out.println("7.  Save Data");
        System.out.println("8.  Export to CSV");
        System.out.println("9.  Import from CSV");
        System.out.println("10. Exit");
        System.out.println("─────────────────────────────────────────");
        System.out.print("Enter choice (1-10): ");
    }

    public void addStudent() {
        System.out.println("\n--- Add New Student ---");

        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Student ID: ");
            String id = scanner.nextLine();

            if (studentsById.containsKey(id)) {
                System.out.println("✗ Student ID already exists!");
                return;
            }

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Major: ");
            String major = scanner.nextLine();

            System.out.print("GPA (0.0-4.0): ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();

            if (gpa < 0.0 || gpa > 4.0) {
                throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
            }

            Student student = new Student(name, age, id, email, major, gpa);
            students.add(student);
            studentsById.put(id, student);

            System.out.println("✓ Student added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("✗ Invalid input: " + e.getMessage());
            scanner.nextLine(); // Clear buffer
        } catch (Exception e) {
            System.out.println("✗ Error adding student: " + e.getMessage());
            scanner.nextLine(); // Clear buffer
        }
    }

    public void displayAllStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println("\nStudent #" + (i + 1));
            students.get(i).displayInfo();
            System.out.println("═".repeat(40));
        }

        System.out.println("Total students: " + students.size());
    }

    public void searchStudent() {
        System.out.println("\n--- Search Student ---");
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();

        ArrayList<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.matches(keyword)) {
                results.add(student);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nFound " + results.size() + " student(s):");
            for (Student student : results) {
                System.out.println();
                student.displayInfo();
                System.out.println("─".repeat(40));
            }
        }
    }

    public void updateGPA() {
        System.out.println("\n--- Update Student GPA ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = studentsById.get(id);
        if (student == null) {
            System.out.println("✗ Student not found.");
            return;
        }

        try {
            System.out.println("Current GPA: " + student.getGpa());
            System.out.print("Enter new GPA (0.0-4.0): ");
            double newGpa = scanner.nextDouble();
            scanner.nextLine();

            if (newGpa < 0.0 || newGpa > 4.0) {
                throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
            }

            student.setGpa(newGpa);
            System.out.println("✓ GPA updated successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("✗ " + e.getMessage());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("✗ Invalid input!");
            scanner.nextLine();
        }
    }

    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = studentsById.get(id);
        if (student == null) {
            System.out.println("✗ Student not found.");
            return;
        }

        System.out.println("\nStudent to delete:");
        student.displayInfo();

        System.out.print("\nAre you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            students.remove(student);
            studentsById.remove(id);
            System.out.println("✓ Student deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public void displayHonorRoll() {
        System.out.println("\n--- Honor Roll (GPA >= 3.5) ---");

        ArrayList<Student> honorStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isHonorRoll()) {
                honorStudents.add(student);
            }
        }

        if (honorStudents.isEmpty()) {
            System.out.println("No students on honor roll.");
        } else {
            for (Student student : honorStudents) {
                student.displayInfo();
                System.out.println("─".repeat(40));
            }
            System.out.println("Total: " + honorStudents.size());
        }
    }

    public void exportData() {
        System.out.println("\n--- Export Data ---");
        System.out.print("Enter filename (e.g., export.csv): ");
        String filename = scanner.nextLine();

        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        FileManager.exportToCSV(students, filename);
    }

    public void importData() {
        System.out.println("\n--- Import Data ---");
        System.out.print("Enter filename to import: ");
        String filename = scanner.nextLine();

        try {
            ArrayList<Student> importedStudents = FileManager.importFromCSV(filename);

            if (importedStudents.isEmpty()) {
                System.out.println("No valid students to import.");
                return;
            }

            System.out.print("\nImport " + importedStudents.size() + " students? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                int addedCount = 0;
                int skippedCount = 0;

                for (Student student : importedStudents) {
                    if (studentsById.containsKey(student.getId())) {
                        System.out.println("Skipping duplicate ID: " + student.getId());
                        skippedCount++;
                    } else {
                        students.add(student);
                        studentsById.put(student.getId(), student);
                        addedCount++;
                    }
                }

                System.out.println("\n✓ Import complete!");
                System.out.println("Added: " + addedCount);
                System.out.println("Skipped (duplicates): " + skippedCount);
            } else {
                System.out.println("Import cancelled.");
            }

        } catch (IOException e) {
            System.out.println("✗ Import failed: " + e.getMessage());
        } catch (InvalidDataException e) {
            System.out.println("✗ Data error: " + e.getMessage());
        }
    }

    public void run() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  Welcome to Student Management System  ║");
        System.out.println("║           with File Persistence        ║");
        System.out.println("╚════════════════════════════════════════╝");

        int choice;
        do {
            displayMenu();

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: displayAllStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateGPA(); break;
                    case 5: deleteStudent(); break;
                    case 6: displayHonorRoll(); break;
                    case 7: saveData(); break;
                    case 8: exportData(); break;
                    case 9: importData(); break;
                    case 10:
                        System.out.println("\nSaving data before exit...");
                        saveData();
                        System.out.println("Thank you for using the system!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("✗ Invalid choice! Please enter 1-10.");
                }

            } catch (Exception e) {
                System.out.println("✗ Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                choice = 0; // Continue loop
            }

        } while (choice != 10);

        scanner.close();
    }

    public static void main(String[] args) {
        PersistentUniversitySystem system = new PersistentUniversitySystem();
        system.run();
    }
}