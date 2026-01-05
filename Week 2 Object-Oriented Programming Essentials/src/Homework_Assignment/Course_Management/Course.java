package Homework_Assignment.Course_Management;

public class Course {
    private String courseCode; // e.g., "CS101"
    private String courseName; // e.g., "Intro to Java"
    private int credits;       // e.g., 3

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    // Getters
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }

    // Display method for the course
    public void displayCourse() {
        System.out.println(courseCode + ": " + courseName + " (" + credits + " credits)");
    }
}