package HANDS_ON_PROJECT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EnhancedUniversitySystem {
    private HashMap<String, Person> peopleById;  // ID -> Person
    private ArrayList<Student> students;
    private ArrayList<String> availableCourses;
    private Scanner scanner;

    public EnhancedUniversitySystem() {
        peopleById = new HashMap<>();
        students = new ArrayList<>();
        availableCourses = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeCourses();
    }

    private void initializeCourses() {
        availableCourses.add("CS101 - Intro to Programming");
        availableCourses.add("CS201 - Data Structures");
        availableCourses.add("CS301 - Algorithms");
        availableCourses.add("MATH101 - Calculus I");
        availableCourses.add("MATH201 - Linear Algebra");
        availableCourses.add("ENG101 - English Composition");
    }

    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   ENHANCED UNIVERSITY SYSTEM           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1.  Add Student");
        System.out.println("2.  Display All Students");
        System.out.println("3.  Search by Keyword");
        System.out.println("4.  Find Student by ID");
        System.out.println("5.  Display Honor Roll");
        System.out.println("6.  Enroll Student in Course");
        System.out.println("7.  Drop Student from Course");
        System.out.println("8.  Assign Grade");
        System.out.println("9.  Display Available Courses");
        System.out.println("10. Show Statistics");
        System.out.println("11. List Students by Major");
        System.out.println("12. Exit");
        System.out.println("─────────────────────────────────────────");
        System.out.print("Enter choice (1-12): ");
    }

    public void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Student ID: ");
        String id = scanner.nextLine();

        if (peopleById.containsKey(id)) {
            System.out.println("✗ ID already exists!");
            return;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Major: ");
        String major = scanner.nextLine();
        System.out.print("GPA (0.0-4.0): ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(name, age, id, email, major, gpa);
        peopleById.put(id, student);
        students.add(student);

        System.out.println("✓ Student added successfully!");
    }

    public void displayAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students in system.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println("\nStudent #" + (i + 1));
            students.get(i).displayInfo();
            System.out.println("═".repeat(40));
        }
        System.out.println("Total students: " + students.size());
    }

    public void searchByKeyword() {
        System.out.println("\n--- Search by Keyword ---");
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        ArrayList<Person> results = new ArrayList<>();
        for (Person person : peopleById.values()) {
            if (person.matches(keyword)) {
                results.add(person);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("\nFound " + results.size() + " result(s):");
            for (Person person : results) {
                System.out.println("\n" + "─".repeat(40));
                person.displayInfo();
            }
        }
    }

    public void findById() {
        System.out.println("\n--- Find by ID ---");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        Person person = peopleById.get(id);
        if (person != null) {
            System.out.println("\n✓ Found:");
            person.displayInfo();
        } else {
            System.out.println("✗ Person not found.");
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

    public void enrollInCourse() {
        System.out.println("\n--- Enroll in Course ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Person person = peopleById.get(id);
        if (person == null || !(person instanceof Student)) {
            System.out.println("✗ Student not found.");
            return;
        }

        Student student = (Student) person;

        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < availableCourses.size(); i++) {
            System.out.println((i + 1) + ". " + availableCourses.get(i));
        }

        System.out.print("Enter course number: ");
        int courseNum = scanner.nextInt();
        scanner.nextLine();

        if (courseNum >= 1 && courseNum <= availableCourses.size()) {
            student.enrollCourse(availableCourses.get(courseNum - 1));
        } else {
            System.out.println("✗ Invalid course number.");
        }
    }

    public void dropCourse() {
        System.out.println("\n--- Drop Course ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Person person = peopleById.get(id);
        if (person == null || !(person instanceof Student)) {
            System.out.println("✗ Student not found.");
            return;
        }

        Student student = (Student) person;
        ArrayList<String> enrolled = student.getEnrolledCourses();

        if (enrolled.isEmpty()) {
            System.out.println("Student not enrolled in any courses.");
            return;
        }

        System.out.println("\nEnrolled Courses:");
        for (int i = 0; i < enrolled.size(); i++) {
            System.out.println((i + 1) + ". " + enrolled.get(i));
        }

        System.out.print("Enter course number to drop: ");
        int courseNum = scanner.nextInt();
        scanner.nextLine();

        if (courseNum >= 1 && courseNum <= enrolled.size()) {
            student.dropCourse(enrolled.get(courseNum - 1));
        } else {
            System.out.println("✗ Invalid course number.");
        }
    }

    public void assignGrade() {
        System.out.println("\n--- Assign Grade ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Person person = peopleById.get(id);
        if (person == null || !(person instanceof Student)) {
            System.out.println("✗ Student not found.");
            return;
        }

        Student student = (Student) person;
        ArrayList<String> enrolled = student.getEnrolledCourses();

        if (enrolled.isEmpty()) {
            System.out.println("Student not enrolled in any courses.");
            return;
        }

        System.out.println("\nEnrolled Courses:");
        for (int i = 0; i < enrolled.size(); i++) {
            System.out.println((i + 1) + ". " + enrolled.get(i));
        }

        System.out.print("Enter course number: ");
        int courseNum = scanner.nextInt();
        scanner.nextLine();

        if (courseNum >= 1 && courseNum <= enrolled.size()) {
            System.out.print("Enter grade (A, B, C, D, F): ");
            String grade = scanner.nextLine().toUpperCase();
            student.assignGrade(enrolled.get(courseNum - 1), grade);
        } else {
            System.out.println("✗ Invalid course number.");
        }
    }

    public void displayAvailableCourses() {
        System.out.println("\n--- Available Courses ---");
        for (String course : availableCourses) {
            System.out.println("• " + course);
        }
        System.out.println("\nTotal courses: " + availableCourses.size());
    }

    public void showStatistics() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         SYSTEM STATISTICS            ║");
        System.out.println("╚══════════════════════════════════════╝");

        // Total students
        System.out.println("Total Students: " + students.size());

        if (students.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }

        // Average GPA
        double totalGpa = 0;
        for (Student student : students) {
            totalGpa += student.getGpa();
        }
        double avgGpa = totalGpa / students.size();
        System.out.println("Average GPA: " + String.format("%.2f", avgGpa));

        // Honor roll count
        int honorCount = 0;
        for (Student student : students) {
            if (student.isHonorRoll()) {
                honorCount++;
            }
        }
        System.out.println("Honor Roll Students: " + honorCount);

        // Students by major
        HashMap<String, Integer> majorCount = new HashMap<>();
        for (Student student : students) {
            String major = student.getMajor();
            majorCount.put(major, majorCount.getOrDefault(major, 0) + 1);
        }

        System.out.println("\nStudents by Major:");
        for (String major : majorCount.keySet()) {
            System.out.println("  " + major + ": " + majorCount.get(major));
        }

        // Most popular courses
        HashMap<String, Integer> courseEnrollment = new HashMap<>();
        for (Student student : students) {
            for (String course : student.getEnrolledCourses()) {
                courseEnrollment.put(course, courseEnrollment.getOrDefault(course, 0) + 1);
            }
        }

        if (!courseEnrollment.isEmpty()) {
            System.out.println("\nCourse Enrollments:");
            for (String course : courseEnrollment.keySet()) {
                System.out.println("  " + course + ": " + courseEnrollment.get(course) + " students");
            }
        }
    }

    public void listByMajor() {
        System.out.println("\n--- Students by Major ---");

        // Group students by major
        HashMap<String, ArrayList<Student>> studentsByMajor = new HashMap<>();

        for (Student student : students) {
            String major = student.getMajor();
            if (!studentsByMajor.containsKey(major)) {
                studentsByMajor.put(major, new ArrayList<>());
            }
            studentsByMajor.get(major).add(student);
        }

        if (studentsByMajor.isEmpty()) {
            System.out.println("No students in system.");
            return;
        }

        for (String major : studentsByMajor.keySet()) {
            System.out.println("\n=== " + major + " ===");
            ArrayList<Student> majorStudents = studentsByMajor.get(major);
            for (Student student : majorStudents) {
                System.out.println("  • " + student.getName() + " (GPA: " + student.getGpa() + ")");
            }
            System.out.println("Total: " + majorStudents.size());
        }
    }

    public void run() {
        System.out.println("Welcome to Enhanced University Management System!");

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAllStudents(); break;
                case 3: searchByKeyword(); break;
                case 4: findById(); break;
                case 5: displayHonorRoll(); break;
                case 6: enrollInCourse(); break;
                case 7: dropCourse(); break;
                case 8: assignGrade(); break;
                case 9: displayAvailableCourses(); break;
                case 10: showStatistics(); break;
                case 11: listByMajor(); break;
                case 12:
                    System.out.println("\nThank you for using the system!");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        } while (choice != 12);

        scanner.close();
    }

    public static void main(String[] args) {
        EnhancedUniversitySystem system = new EnhancedUniversitySystem();
        system.run();
    }
}
