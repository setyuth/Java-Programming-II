package Homework_Assignment.Task3;

import Homework_Assignment.Teacher;

import java.util.ArrayList;

public class Department {
    private String departmentName;
    private String departmentCode;

    // Composition: The Department OWNS a list of Teachers
    private ArrayList<Teacher> teachers;

    public Department(String departmentName, String departmentCode) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println(teacher.getName() + " added to " + departmentName);
    }

    public void removeTeacher(String teacherId) {
        teachers.removeIf(t -> t.getId().equals(teacherId));
        System.out.println("Teacher removed if ID matched.");
    }

    public double calculateAverageSalary() {
        // Check if list is empty (avoid divide by zero!)
        if (teachers.isEmpty()) return 0.0;

        double total = 0;

        // Loop through teachers
        for (Teacher t : teachers) {
            total += t.getSalary();
        }

        // Divide by count
        return total / teachers.size();
    }

    public void listAllTeachers() {
        System.out.println("\n--- Department: " + departmentName + " (" + departmentCode + ") ---");
        for (Teacher t : teachers) {
            System.out.println("- " + t.getName() + " (" + t.getSubject() + ")");
        }
        System.out.println("Average Salary: $" + String.format("%.2f", calculateAverageSalary()));
    }
}
