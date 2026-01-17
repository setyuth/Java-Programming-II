package Homework_Assignment;

import Homework_Assignment.Task1.GraduateStudent;
import Homework_Assignment.Task2.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class UniversityManagementSystem {
    private ArrayList<Person> people;
    private Scanner scanner;

    public UniversityManagementSystem() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   UNIVERSITY MANAGEMENT SYSTEM v2.0    ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. Add Student (Undergrad/Grad)"); // Updated Label
        System.out.println("2. Add Teacher");
        System.out.println("3. Add Admin");
        System.out.println("4. Display All People");
        System.out.println("5. Search Person by ID");
        System.out.println("6. Display by Role");
        System.out.println("7. Display Honor Roll Students");
        System.out.println("8. Perform Thesis Defense (Grad Only)"); // New Feature
        System.out.println("9. Exit");
        System.out.println("─────────────────────────────────────────");
        System.out.print("Enter your choice (1-9): ");
    }

    public void addStudent() {
        System.out.println("\n--- Add New Student ---");

        // Ask for Student Type
        System.out.print("Is this a Graduate Student? (y/n): ");
        String isGrad = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Major: ");
        String major = scanner.nextLine();
        System.out.print("GPA (0.0-4.0): ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        if (isGrad.equalsIgnoreCase("y")) {
            // Task 1: Collect Graduate specific info
            System.out.print("Thesis Title: ");
            String thesis = scanner.nextLine();
            System.out.print("Advisor Name: ");
            String advisor = scanner.nextLine();

            GraduateStudent gradStudent = new GraduateStudent(name, age, id, email, major, gpa, thesis, advisor);
            people.add(gradStudent);
            System.out.println("✓ Graduate Student added successfully!");
        } else {
            // Standard Undergraduate
            Student student = new Student(name, age, id, email, major, gpa);
            people.add(student);
            System.out.println("✓ Student added successfully!");
        }
    }

    // ... [Keep addTeacher, addAdmin, displayAllPeople, searchById, displayByRole, displayHonorRoll exactly as they were] ...
    // Note: I am omitting the unchanged methods to save space, but you should keep them in your file.

    // Copy/Paste your existing addTeacher(), addAdmin(), displayAllPeople(), searchById() etc here.

    public void addTeacher() {
        // [Existing Code from your file]
        System.out.println("\n--- Add New Teacher ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Teacher ID: ");
        String id = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Years of Experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine();

        Teacher teacher = new Teacher(name, age, id, email, department, subject, salary, experience);
        people.add(teacher);
        System.out.println("✓ Teacher added successfully!");
    }

    public void addAdmin() {
        // [Existing Code from your file]
        System.out.println("\n--- Add New Admin ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Admin ID: ");
        String id = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Number of permissions: ");
        int numPerms = scanner.nextInt();
        scanner.nextLine();

        String[] permissions = new String[numPerms];
        for (int i = 0; i < numPerms; i++) {
            System.out.print("Permission " + (i + 1) + ": ");
            permissions[i] = scanner.nextLine();
        }

        Admin admin = new Admin(name, age, id, email, position, department, permissions);
        people.add(admin);
        System.out.println("✓ Admin added successfully!");
    }

    public void displayAllPeople() {
        // [Existing Code from your file]
        System.out.println("\n--- All People in System ---");
        if (people.isEmpty()) {
            System.out.println("No people in the system.");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            System.out.println("\nPerson #" + (i + 1) + " [" + people.get(i).getRole() + "]");
            people.get(i).displayInfo();
            System.out.println("═".repeat(40));
        }
        System.out.println("Total people: " + people.size());
    }

    public void searchById() {
        // [Existing Code from your file]
        System.out.println("\n--- Search Person by ID ---");
        System.out.print("Enter ID: ");
        String searchId = scanner.nextLine();

        boolean found = false;
        for (Person person : people) {
            if (person.getId().equalsIgnoreCase(searchId)) {
                System.out.println("\n✓ Person found:");
                person.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Person not found.");
        }
    }

    public void displayByRole() {
        // [Existing Code from your file]
        System.out.println("\n--- Filter by Role ---");
        System.out.println("1. Students only");
        System.out.println("2. Teachers only");
        System.out.println("3. Admins only");
        System.out.print("Choose (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String roleFilter = "";
        switch (choice) {
            case 1: roleFilter = "Student"; break;
            case 2: roleFilter = "Teacher"; break;
            case 3: roleFilter = "Admin"; break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\n--- " + roleFilter + "s ---");
        int count = 0;
        for (Person person : people) {
            // Polymorphism handling: GraduateStudent is also a Student
            // So looking for "Student" role might need adjustment if getRole returns "Student" for grads
            // In our code, GraduateStudent inherits getRole "Student" unless we override it.
            // Let's check GraduateStudent class. We didn't override getRole() there, so it returns "Student".
            // Perfect! It will show up under Students.
            if (person.getRole().equals(roleFilter)) {
                person.displayInfo();
                System.out.println("─".repeat(40));
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No " + roleFilter.toLowerCase() + "s found.");
        } else {
            System.out.println("Total " + roleFilter.toLowerCase() + "s: " + count);
        }
    }

    public void displayHonorRoll() {
        // [Existing Code from your file]
        System.out.println("\n--- Honor Roll Students (GPA >= 3.5) ---");
        int count = 0;

        for (Person person : people) {
            // Use instanceof to check object type
            if (person instanceof Student) {
                Student student = (Student) person;  // Cast to Student
                if (student.isHonorRoll()) {
                    student.displayInfo();
                    System.out.println("─".repeat(40));
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println("No students on honor roll.");
        } else {
            System.out.println("Total honor roll students: " + count);
        }
    }

    // New method to utilize the GraduateStudent specific method
    public void performThesisDefense() {
        System.out.print("Enter Graduate Student ID: ");
        String searchId = scanner.nextLine();

        for (Person person : people) {
            if (person.getId().equalsIgnoreCase(searchId)) {
                if (person instanceof GraduateStudent) {
                    ((GraduateStudent) person).defendThesis();
                } else {
                    System.out.println("Error: This person is not a Graduate Student.");
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void run() {
        System.out.println("Welcome to University Management System!");

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: addTeacher(); break;
                case 3: addAdmin(); break;
                case 4: displayAllPeople(); break;
                case 5: searchById(); break;
                case 6: displayByRole(); break;
                case 7: displayHonorRoll(); break;
                case 8: performThesisDefense(); break; // New Case
                case 9: // Updated Exit case
                    System.out.println("\nThank you for using University Management System!");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("\n✗ Invalid choice! Please enter 1-9.");
            }

        } while (choice != 9);

        scanner.close();
    }

    public static void main(String[] args) {
        UniversityManagementSystem ums = new UniversityManagementSystem();
        ums.run();
    }
}