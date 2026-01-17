package Homework_Assignment;

public class Teacher extends Person {
    private String department;
    private String subject;
    private double salary;
    private int yearsOfExperience;

    public Teacher(String name, int age, String id, String email,
                   String department, String subject, double salary, int yearsOfExperience) {
        super(name, age, id, email);
        this.department = department;
        this.subject = subject;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void displayInfo() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         TEACHER INFORMATION          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Teacher ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Subject: " + subject);
        System.out.println("Salary: $" + salary);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Level: " + getTeacherLevel());
    }

    @Override
    public String getRole() {
        return "Teacher";
    }

    public String getDepartment() {
        return department;
    }

    public String getSubject() {
        return subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public void giveRaise(double percentage) {
        double raise = salary * (percentage / 100);
        salary += raise;
        System.out.println("Salary increased by " + percentage + "%. New salary: $" + salary);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getTeacherLevel() {
        if (yearsOfExperience < 3) return "Junior Teacher";
        else if (yearsOfExperience < 10) return "Senior Teacher";
        else return "Master Teacher";
    }
}
