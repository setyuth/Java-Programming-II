package Inheritance;

public class Student extends Person {
    private String studentId;
    private double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);  // 1. Call parent constructor
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void introduce() {
        super.introduce();  // 2. Call parent method
        System.out.println("I'm a student with ID: " + studentId);
        System.out.println("My GPA is: " + gpa);
    }

    public void study() {
        // 3. Access parent attribute
        System.out.println(super.name + " is studying hard!");
    }
}