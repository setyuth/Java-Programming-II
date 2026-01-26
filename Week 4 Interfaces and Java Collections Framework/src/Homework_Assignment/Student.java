package Homework_Assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

// Task 2: implement the Comparable interface.
public class Student extends Person  implements Comparable<Student> {
    private String major;
    private double gpa;
    private ArrayList<String> enrolledCourses;
    private HashMap<String, String> courseGrades;  // Course -> Grade
    // Task 1: Add this field to the Student class
    private LinkedList<String> attendanceDates;

    public Student(String name, int age, String id, String email, String major, double gpa) {
        super(name, age, id, email);
        this.major = major;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
        this.attendanceDates = new LinkedList<>();  // Initialize LinkedList
    }

    @Override
    public void displayInfo() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         STUDENT INFORMATION          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        System.out.println("Attendance Days: " + attendanceDates.size());  // NEW LINE

        if (!enrolledCourses.isEmpty()) {
            System.out.println("\nCourses:");
            for (String course : enrolledCourses) {
                String grade = courseGrades.get(course);
                System.out.println("  - " + course +
                        (grade != null ? " (Grade: " + grade + ")" : " (In Progress)"));
            }
        }
    }

    @Override
    public String getRole() {
        return "Student";
    }

    // Course management methods
    public void enrollCourse(String course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            System.out.println("✓ Enrolled in " + course);
        } else {
            System.out.println("Already enrolled in " + course);
        }
    }

    public void dropCourse(String course) {
        if (enrolledCourses.remove(course)) {
            courseGrades.remove(course);
            System.out.println("✓ Dropped " + course);
        } else {
            System.out.println("Not enrolled in " + course);
        }
    }

    public void assignGrade(String course, String grade) {
        if (enrolledCourses.contains(course)) {
            courseGrades.put(course, grade);
            System.out.println("✓ Grade assigned: " + course + " -> " + grade);
        } else {
            System.out.println("Not enrolled in " + course);
        }
    }

    public ArrayList<String> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public boolean isHonorRoll() {
        return gpa >= 3.5;
    }

    @Override
    public boolean matches(String keyword) {
        return super.matches(keyword) || major.toLowerCase().contains(keyword.toLowerCase());
    }

    // Task 1
    // Mark attendance for today
    public void markAttendance() {
        // Get current date in a simple format
        LocalDate today = LocalDate.now();
        String dateStr = today.toString();

        // Add to the beginning of the list (most recent first)
        attendanceDates.addFirst(dateStr);
        System.out.println("✓ Attendance marked for " + dateStr);
    }

    // Get total attendance count
    public int getAttendanceCount() {
        return attendanceDates.size();
    }

    // Task 1
    // Display last 5 attendance dates
    public void displayAttendance() {
        System.out.println("\n--- Attendance Records ---");
        if (attendanceDates.isEmpty()) {
            System.out.println("No attendance records.");
            return;
        }

        System.out.println("Total attendance: " + attendanceDates.size() + " days");
        System.out.println("Recent attendance (last 5):");

        // Display only the first 5 entries (most recent)
        int count = Math.min(5, attendanceDates.size());
        for (int i = 0; i < count; i++) {
            System.out.println("  " + (i + 1) + ". " + attendanceDates.get(i));
        }
    }

    // Task 2
    @Override
    public int compareTo(Student other) {
        // Compare students by name (alphabetically)
        int nameComparison = this.name.compareTo(other.name);

        // If names are the same, compare by ID to ensure uniqueness
        if (nameComparison == 0) {
            return this.id.compareTo(other.id);
        }

        return nameComparison;
    }

    // Task 3:Advanced Statistics Method
    public String getGrade(String course) {
        return courseGrades.get(course);
    }
}
