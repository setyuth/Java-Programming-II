package Homework_Assignment.Task1;

import Homework_Assignment.Task2.Student;

// 1. EXTENDS: We inherit all Student traits
public class GraduateStudent extends Student {
    // 2. NEW FIELDS: Only what is specific to Grad students
    private String thesisTitle;
    private String advisor;

    // 3. SUPER: How we pass data up to the parent class
    public GraduateStudent(String name, int age, String id, String email, String major, double gpa,
                           String thesisTitle, String advisor) {
        super(name, age, id, email, major, gpa);
        this.thesisTitle = thesisTitle;
        this.advisor = advisor;
    }

    @Override
    public String getAcademicStatus() {
        return "Graduate Student"; // We change the behavior!
    }

    public void defendThesis() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║            THESIS DEFENSE            ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Student: " + getName());
        System.out.println("Title:   " + thesisTitle);
        System.out.println("Advisor: " + advisor);
        System.out.println("Status:  " + (getGpa() > 3.0 ? "PASSED" : "PENDING REVIEW"));
    }

    @Override
    public void displayInfo() {
        // We override this to include graduate specific details
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     GRADUATE STUDENT INFORMATION     ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Student ID: " + getId());
        System.out.println("Email: " + getEmail());
        System.out.println("Major: " + getMajor());
        System.out.println("GPA: " + getGpa());
        System.out.println("Credits Completed: " + getCreditsCompleted());
        System.out.println("Status: " + getAcademicStatus());
        System.out.println("----------------------------------------");
        System.out.println("Thesis: " + thesisTitle);
        System.out.println("Advisor: " + advisor);
    }
}