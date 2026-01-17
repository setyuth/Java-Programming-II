package HANDS_ON_PROJECT;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {
    private String major;
    private double gpa;
    private ArrayList<String> enrolledCourses;
    private HashMap<String, String> courseGrades;  // Course -> Grade

    public Student(String name, int age, String id, String email, String major, double gpa) {
        super(name, age, id, email);
        this.major = major;
        this.gpa = gpa;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
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
}
