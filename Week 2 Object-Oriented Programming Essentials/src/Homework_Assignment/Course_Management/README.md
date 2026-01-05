# 📚 Task 2: Adding Course Management

In this task, we expand our Student Management System to handle **Course Enrollment**. This introduces the concept of *Object Composition* (a Student *HAS-A* list of Courses).

## 🎯 Objectives
1.  Create a `Course` class.
2.  Update the `Student` class to store a list of courses.
3.  Implement logic to enroll, drop, and calculate credits.

---
### 1. New File: `Course.java`

This class represents a single course.

```java
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

```

### 2. Updated `Student.java`

I have added the `enrolledCourses` list and the required methods (enroll, drop, calculate credits).

```java
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

```

### 3. Updated `StudentManagementSystem.java`

I added a new menu option `7. Manage Student Courses` which opens a sub-menu to enroll, drop, or view courses for a specific student.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   STUDENT MANAGEMENT SYSTEM            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. Add New Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Update Student GPA");
        System.out.println("5. Delete Student");
        System.out.println("6. Display Honor Roll Students");
        System.out.println("7. Manage Student Courses (NEW)");
        System.out.println("8. Exit");
        System.out.println("─────────────────────────────────────────");
        System.out.print("Enter your choice (1-8): ");
    }

    // ... [Previous methods: addStudent, displayAllStudents, searchStudent, etc. remain the same] ...
    // Note: Copied previous methods here for context, ensuring the class is complete.
    
    public void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        System.out.print("Enter GPA (0.0-4.0): ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        students.add(new Student(id, name, age, major, gpa));
        System.out.println("✓ Student added successfully!");
    }

    public void displayAllStudents() {
        // ... (Same as previous task)
        for (Student s : students) { s.displayInfo(); System.out.println("---"); }
    }
    
    public void searchStudent() {
        // ... (Same as previous task)
        System.out.print("Search Name: ");
        String name = scanner.nextLine();
        for(Student s : students) if(s.getName().equalsIgnoreCase(name)) s.displayInfo();
    }
    
    public void updateGPA() {
        // ... (Same as previous task)
        System.out.print("Student Name: ");
        String name = scanner.nextLine();
        for(Student s : students) {
            if(s.getName().equalsIgnoreCase(name)) {
                System.out.print("New GPA: ");
                s.setGpa(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Updated.");
                return;
            }
        }
    }
    
    public void deleteStudent() {
         // ... (Same as previous task)
         System.out.print("Student Name: ");
         String name = scanner.nextLine();
         students.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }
    
    public void displayHonorRoll() {
        // ... (Same as previous task)
        for(Student s : students) if(s.isHonorRoll()) s.displayInfo();
    }

    // --- NEW: Course Management Menu ---
    public void manageCourses() {
        System.out.println("\n--- Manage Student Courses ---");
        System.out.print("Enter student name to manage: ");
        String name = scanner.nextLine();

        Student foundStudent = null;
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                foundStudent = s;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("✗ Student not found.");
            return;
        }

        // Sub-menu for the specific student
        boolean back = false;
        while (!back) {
            System.out.println("\nManaging Courses for: " + foundStudent.getName());
            System.out.println("1. Enroll in Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Enrolled Courses");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Course Code (e.g. CS101): ");
                    String code = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();
                    
                    Course newCourse = new Course(code, cName, credits);
                    foundStudent.enrollCourse(newCourse);
                    break;
                case 2:
                    System.out.print("Enter Course Code to Drop: ");
                    String dropCode = scanner.nextLine();
                    foundStudent.dropCourse(dropCode);
                    break;
                case 3:
                    foundStudent.displayEnrolledCourses();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void run() {
        System.out.println("Welcome to Student Management System!");
        int choice;
        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.next(); 
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAllStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateGPA(); break;
                case 5: deleteStudent(); break;
                case 6: displayHonorRoll(); break;
                case 7: manageCourses(); break; // New Option
                case 8: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}

```

---

## 🧠 Key Concepts Explained

### 1. Composition (Has-A Relationship)
Previously, our `Student` class only had simple data types (Strings, ints). Now, we are giving the Student a complex object: a list of `Course` objects.

* **Relationship:** A `Student` *has* many `Courses`.
* **Implementation:** We use `ArrayList<Course>` inside the `Student` class.

### 2. Inner Lists
Inside `Student.java`:
```java
// This list lives INSIDE a specific student object
private ArrayList<Course> enrolledCourses;

```

Every time we create a `new Student()`, we must initialize this list:

```java
this.enrolledCourses = new ArrayList<>();

```

If we forget this step, we will get a `NullPointerException` when trying to enroll a student.

### 3. Iterating to Calculate Totals

To find the total credits, we can't just look at a single variable. We must loop through the list and add up the values.

```java
public int calculateTotalCredits() {
    int total = 0;
    // For every Course 'c' in the list 'enrolledCourses'
    for (Course c : enrolledCourses) {
        total = total + c.getCredits();
    }
    return total;
}

```

### 4. Dropping a Course (Searching and Removing)

To drop a course, we first need to find it by its unique code (e.g., "CS101"). We cannot simply say "remove CS101" because the list stores `Course` objects, not Strings.

```java
// Loop to find the object that matches the code
for (int i = 0; i < enrolledCourses.size(); i++) {
    if (enrolledCourses.get(i).getCourseCode().equals(code)) {
        enrolledCourses.remove(i); // Remove the object at this index
        break; // Stop looking
    }
}

```

---

## 🛠 Feature Walkthrough

### Class: `Course`

A simple "blueprint" class. It has no logic, just data:

* `courseCode` (String)
* `courseName` (String)
* `credits` (int)

### Class: `Student` updates

* **`enrollCourse(Course c)`**: Adds a course object to the student's personal list.
* **`dropCourse(String code)`**: Removes a course if the code matches.
* **`displayEnrolledCourses()`**: A helper method to print the student's schedule.

### Main System updates

We added a **Sub-menu**. When you select "Manage Student Courses", the program:

1. Asks for the student's name.
2. Enters a "loop within a loop" where you can Enroll, Drop, or View courses for *that specific student* until you choose to go back.

---

## 🧪 How to Test

1. **Add a Student**: Create a student named "Alice".
2. **Manage Courses**: Select option 7 and type "Alice".
3. **Enroll**: Choose option 1. Enter "CS101", "Intro to Code", "3".
4. **Enroll Again**: Choose option 1. Enter "MATH202", "Calculus", "4".
5. **View**: Choose option 3. You should see both courses and a Total Credits of 7.
6. **Drop**: Choose option 2. Enter "CS101".
7. **View**: Verify that only "MATH202" remains and Total Credits is now 4.
