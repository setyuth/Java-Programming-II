package HANDS_ON_PROJECT;

import HANDS_ON_PROJECT.Exception.InvalidDataException;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {
    private String major;
    private double gpa;
    private HashMap<String, String> courseGrades;  // Course -> Grade
    private ArrayList<String> enrolledCourses;

    public Student(String name, int age, String id, String email, String major, double gpa) {
        super(name, age, id, email);
        this.major = major;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
    }

    // Convert student to CSV format
    public String toCSV() {
        // Format: name,age,id,email,major,gpa,course1;course2;course3
        String courses = String.join(";", enrolledCourses);
        return String.format("%s,%d,%s,%s,%s,%.2f,%s",
                name, age, id, email, major, gpa, courses);
    }

    // Create student from CSV line
    public static Student fromCSV(String csvLine) throws InvalidDataException {
        try {
            String[] parts = csvLine.split(",");
            if (parts.length < 6) {
                throw new InvalidDataException("Invalid CSV format: insufficient fields");
            }

            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            String id = parts[2];
            String email = parts[3];
            String major = parts[4];
            double gpa = Double.parseDouble(parts[5]);

            Student student = new Student(name, age, id, email, major, gpa);

            // Add courses if present
            if (parts.length > 6 && !parts[6].isEmpty()) {
                String[] courses = parts[6].split(";");
                for (String course : courses) {
                    student.enrollCourse(course);
                }
            }

            return student;

        } catch (NumberFormatException e) {
            throw new InvalidDataException("Invalid number format in CSV: " + csvLine);
        }
    }

    // Other methods from previous weeks...
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

        if (!enrolledCourses.isEmpty()) {
            System.out.println("\nEnrolled Courses:");
            for (String course : enrolledCourses) {
                System.out.println("  - " + course);
            }
        }
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public void enrollCourse(String course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    public void dropCourse(String course) {
        enrolledCourses.remove(course);
    }

    public ArrayList<String> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    // Getters
    public double getGpa() { return gpa; }
    public String getMajor() { return major; }

    // Setters
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setMajor(String major) { this.major = major; }

    public boolean isHonorRoll() {
        return gpa >= 3.5;
    }

    @Override
    public boolean matches(String keyword) {
        return super.matches(keyword) ||
                major.toLowerCase().contains(keyword.toLowerCase());
    }

    public void assignGrade(String course, String grade) {
        if (enrolledCourses.contains(course)) {
            courseGrades.put(course, grade);
            System.out.println("✓ Grade assigned: " + course + " -> " + grade);
        } else {
            System.out.println("Not enrolled in " + course);
        }
    }
}
