package Java_Collections_Framework_Introduction.arrayList;

import java.util.ArrayList;

class Student {
    String name;
    double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return name + " (GPA: " + gpa + ")";
    }
}

class StudentListDemo {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 3.8));
        students.add(new Student("Bob", 3.2));
        students.add(new Student("Charlie", 3.9));

        System.out.println("All students:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Find student with highest GPA
        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.gpa > topStudent.gpa) {
                topStudent = student;
            }
        }
        System.out.println("\nTop student: " + topStudent);
    }
}