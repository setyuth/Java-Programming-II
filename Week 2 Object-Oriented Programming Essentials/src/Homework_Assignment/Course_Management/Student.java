package Homework_Assignment.Course_Management;

import java.util.ArrayList; // Import required for ArrayList

public class Student {
    // Attributes
    private String studentId;
    private String name;
    private int age;
    private String major;
    private double gpa;

    // NEW: List to store enrolled courses
    private ArrayList<Course> enrolledCourses;

    // Constructor
    public Student(String studentId, String name, int age, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        setAge(age);
        this.major = major;
        setGpa(gpa);
        // Initialize the course list
        this.enrolledCourses = new ArrayList<>();
    }

    // --- NEW METHODS FOR COURSE MANAGEMENT ---

    // 1. Enroll in a course
    public void enrollCourse(Course course) {
        // Check if already enrolled (optional validation)
        for(Course c : enrolledCourses) {
            if(c.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
                System.out.println("⚠ Already enrolled in " + c.getCourseCode());
                return;
            }
        }
        enrolledCourses.add(course);
        System.out.println("✓ Successfully enrolled in " + course.getCourseName());
    }

    // 2. Drop a course by code
    public void dropCourse(String courseCode) {
        boolean removed = false;
        // We use a loop to find the course by its code
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.println("✓ Dropped course: " + enrolledCourses.get(i).getCourseName());
                enrolledCourses.remove(i);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("✗ Course not found in enrollment list.");
        }
    }

    // 3. Display enrolled courses
    public void displayEnrolledCourses() {
        System.out.println("\nCourses for " + name + ":");
        if (enrolledCourses.isEmpty()) {
            System.out.println("  - No courses enrolled.");
        } else {
            for (Course c : enrolledCourses) {
                System.out.print("  - ");
                c.displayCourse();
            }
            System.out.println("  > Total Credits: " + calculateTotalCredits());
        }
    }

    // 4. Calculate total credits
    public int calculateTotalCredits() {
        int total = 0;
        for (Course c : enrolledCourses) {
            total += c.getCredits();
        }
        return total;
    }

    // --- EXISTING GETTERS AND SETTERS ---

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 16 && age <= 100) this.age = age;
        else this.age = 18;
    }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) this.gpa = gpa;
        else this.gpa = 0.0;
    }

    public boolean isHonorRoll() { return gpa >= 3.5; }

    public void displayInfo() {
        System.out.println("ID:    " + studentId);
        System.out.println("Name:  " + name);
        System.out.println("Age:   " + age);
        System.out.println("Major: " + major);
        System.out.println("GPA:   " + gpa);
        // Optional: show number of courses in main summary
        System.out.println("Courses: " + enrolledCourses.size());
    }
}