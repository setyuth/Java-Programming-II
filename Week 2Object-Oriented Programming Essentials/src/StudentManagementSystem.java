import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    // ArrayList to store students
    private ArrayList<Student> students;
    private Scanner scanner;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to display menu
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
        System.out.println("7. Exit");
        System.out.println("─────────────────────────────────────────");
        System.out.print("Enter your choice (1-7): ");
    }

    // Method to add a new student
    public void addStudent() {
        System.out.println("\n--- Add New Student ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter major: ");
        String major = scanner.nextLine();

        System.out.print("Enter GPA (0.0-4.0): ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student student = new Student(name, age, major, gpa);
        students.add(student);

        System.out.println("✓ Student added successfully!");
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println("\nStudent #" + (i + 1));
            students.get(i).displayInfo();
            System.out.println("─────────────────────────");
        }

        System.out.println("Total students: " + students.size());
    }

    // Method to search student by name
    public void searchStudent() {
        System.out.println("\n--- Search Student ---");
        System.out.print("Enter student name: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\n✓ Student found:");
                student.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Student not found.");
        }
    }

    // Method to update student GPA
    public void updateGPA() {
        System.out.println("\n--- Update Student GPA ---");
        System.out.print("Enter student name: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\nCurrent GPA: " + student.getGpa());
                System.out.print("Enter new GPA (0.0-4.0): ");
                double newGpa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                student.setGpa(newGpa);
                System.out.println("✓ GPA updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Student not found.");
        }
    }

    // Method to delete a student
    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter student name: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(searchName)) {
                System.out.print("Are you sure you want to delete " +
                        students.get(i).getName() + "? (yes/no): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    students.remove(i);
                    System.out.println("✓ Student deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Student not found.");
        }
    }

    // Method to display honor roll students
    public void displayHonorRoll() {
        System.out.println("\n--- Honor Roll Students (GPA >= 3.5) ---");

        boolean hasHonorStudents = false;
        for (Student student : students) {
            if (student.isHonorRoll()) {
                student.displayInfo();
                System.out.println("─────────────────────────");
                hasHonorStudents = true;
            }
        }

        if (!hasHonorStudents) {
            System.out.println("No students on honor roll.");
        }
    }

    // Method to run the system
    public void run() {
        System.out.println("Welcome to Student Management System!");

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateGPA();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    displayHonorRoll();
                    break;
                case 7:
                    System.out.println("\nThank you for using Student Management System!");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("\n✗ Invalid choice! Please enter 1-7.");
            }

        } while (choice != 7);

        scanner.close();
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}