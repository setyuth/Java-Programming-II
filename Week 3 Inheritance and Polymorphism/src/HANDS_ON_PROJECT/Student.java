package HANDS_ON_PROJECT;

public class Student extends Person {
    private String major;
    private double gpa;
    private int creditsCompleted;

    public Student(String name, int age, String id, String email, String major, double gpa) {
        super(name, age, id, email);
        this.major = major;
        setGpa(gpa);
        this.creditsCompleted = 0;
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
        System.out.println("Credits Completed: " + creditsCompleted);
        System.out.println("Status: " + getAcademicStatus());
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA! Must be 0.0-4.0");
            this.gpa = 0.0;
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCreditsCompleted() {
        return creditsCompleted;
    }

    public void addCredits(int credits) {
        if (credits > 0) {
            this.creditsCompleted += credits;
            System.out.println("Added " + credits + " credits. Total: " + creditsCompleted);
        }
    }

    public boolean isHonorRoll() {
        return gpa >= 3.5;
    }

    public String getAcademicStatus() {
        if (creditsCompleted < 30) return "Freshman";
        else if (creditsCompleted < 60) return "Sophomore";
        else if (creditsCompleted < 90) return "Junior";
        else return "Senior";
    }
}