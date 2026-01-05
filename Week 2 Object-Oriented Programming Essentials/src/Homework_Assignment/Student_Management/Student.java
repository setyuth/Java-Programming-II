package Homework_Assignment.Student_Management;

public class Student {
    // Private attributes (cannot be accessed directly from outside)
    private String studentId; // 1. Added Student ID
    private String name;
    private int age;
    private String major;
    private double gpa;

    // Constructor
    // 2. Updated Constructor to accept studentId
    public Student(String studentId, String name, int age, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        setAge(age);      // Use setter for validation
        this.major = major;
        setGpa(gpa);      // Use setter for validation
    }

    // Getter methods (read access)
    // 3. Added Getter for Student ID
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    // Setter methods (write access with validation)
    // 3. Added Setter for Student ID
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }

    public void setAge(int age) {
        if (age >= 16 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Must be between 16 and 100.");
            this.age = 18; // Default value
        }
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA! Must be between 0.0 and 4.0.");
            this.gpa = 0.0; // Default value
        }
    }

    // Public method to display info
    public void displayInfo() {
        System.out.println("ID:   " + studentId); // 4. Display ID
        System.out.println("Name: " + name);
        System.out.println("Age:  " + age);
        System.out.println("Major:" + major);
        System.out.println("GPA:  " + gpa);
    }

    public boolean isHonorRoll() {
        return gpa >= 3.5;
    }
}