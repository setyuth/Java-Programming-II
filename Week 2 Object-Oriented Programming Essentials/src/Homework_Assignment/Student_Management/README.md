# 🎓 Student Management System (Java)

A simple console-based application to manage student records. This project demonstrates core Object-Oriented Programming (OOP) concepts in Java, including Encapsulation, Classes, Objects, and ArrayLists.

## 📂 Project Structure

This project consists of two main Java files:

1.  **`Student.java`**: The "Blueprint." It defines what a student looks like (attributes) and what they can do (methods).
2.  **`StudentManagementSystem.java`**: The "Logic." It handles user input, stores the list of students, and performs operations like adding, searching, and deleting.

---
### 1. Refactored `Student.java`

**Changes:** Added `studentId` field, updated constructor, added getter/setter, and updated `displayInfo`.

```java
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

```

### 2. Refactored `StudentManagementSystem.java`

**Changes:** Updated `addStudent` to input the ID.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    // ArrayList to store students
    private ArrayList<Student> students;
    private Scanner scanner;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to display menu
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
        System.out.println("7. Exit");
        System.out.println("─────────────────────────────────────────");
        System.out.print("Enter your choice (1-7): ");
    }

    // Method to add a new student
    public void addStudent() {
        System.out.println("\n--- Add New Student ---");

        // 1. Capture Student ID
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter major: ");
        String major = scanner.nextLine();

        System.out.print("Enter GPA (0.0-4.0): ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // 2. Pass ID to constructor
        Student student = new Student(studentId, name, age, major, gpa);
        students.add(student);

        System.out.println("✓ Student added successfully!");
    }

    // Method to display all students
    public void displayAllStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println("\nStudent #" + (i + 1));
            students.get(i).displayInfo();
            System.out.println("─────────────────────────");
        }

        System.out.println("Total students: " + students.size());
    }

    // Method to search student by name
    public void searchStudent() {
        System.out.println("\n--- Search Student ---");
        System.out.print("Enter student name: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\n✓ Student found:");
                student.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Student not found.");
        }
    }

    // Method to update student GPA
    public void updateGPA() {
        System.out.println("\n--- Update Student GPA ---");
        System.out.print("Enter student name: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\nCurrent GPA: " + student.getGpa());
                System.out.print("Enter new GPA (0.0-4.0): ");
                double newGpa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                student.setGpa(newGpa); // Uses setter validation
                System.out.println("✓ GPA updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Student not found.");
        }
    }

    // Method to delete a student
    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter student name: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(searchName)) {
                System.out.print("Are you sure you want to delete " +
                        students.get(i).getName() + "? (yes/no): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    students.remove(i);
                    System.out.println("✓ Student deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ Student not found.");
        }
    }

    // Method to display honor roll students
    public void displayHonorRoll() {
        System.out.println("\n--- Honor Roll Students (GPA >= 3.5) ---");

        boolean hasHonorStudents = false;
        for (Student student : students) {
            if (student.isHonorRoll()) {
                student.displayInfo();
                System.out.println("─────────────────────────");
                hasHonorStudents = true;
            }
        }

        if (!hasHonorStudents) {
            System.out.println("No students on honor roll.");
        }
    }

    // Method to run the system
    public void run() {
        System.out.println("Welcome to Student Management System!");

        int choice;
        do {
            displayMenu();
            // Basic input validation for menu choice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
                System.out.print("Enter your choice (1-7): ");
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAllStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateGPA(); break;
                case 5: deleteStudent(); break;
                case 6: displayHonorRoll(); break;
                case 7:
                    System.out.println("\nThank you for using Student Management System!");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("\n✗ Invalid choice! Please enter 1-7.");
            }

        } while (choice != 7);

        scanner.close();
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}

```
---
## 🚀 Key Concepts Learned

### 1. Encapsulation
In `Student.java`, all attributes (like `name`, `age`, `gpa`) are `private`. This means other classes cannot access them directly. Instead, we use:
* **Getters:** Methods to *read* the data (e.g., `getName()`).
* **Setters:** Methods to *write* the data (e.g., `setAge()`).
* **Why?** This allows us to add validation logic. For example, `setAge` ensures a student cannot be assigned an age of -5 or 200.

### 2. Constructors
We use a constructor to initialize a new `Student` object.
```java
public Student(String studentId, String name, int age, String major, double gpa)
```
---
This ensures that every time we create a student, we must provide all the necessary information immediately.

### 3. ArrayLists

Instead of a fixed-size array (e.g., `Student[]`), we use `ArrayList<Student>`.

* **Why?** An `ArrayList` is dynamic. It allows us to add or remove students without worrying about the size limit of the list.

### 4. Input Handling (Scanner)

We use the `Scanner` class to read text and numbers from the console.

* **Tip:** When switching from reading a number (`nextInt`) to a string (`nextLine`), we must consume the "newline" character left in the buffer. You will see `scanner.nextLine()` used purely for this purpose in the code.

---

## 🛠 Features

1. **Add New Student**: Input ID, Name, Age, Major, and GPA.
2. **Display All Students**: Lists details of every student in the system.
3. **Search by Name**: Finds a specific student.
4. **Update GPA**: Modifies the GPA of an existing student (with validation).
5. **Delete Student**: Removes a student from the list.
6. **Honor Roll**: Filters and displays only students with a GPA of 3.5 or higher.

---

## 📝 Code Walkthrough

### The `Student` Class

The class now includes a `studentId`.

```java
private String studentId; // Unique identifier

// The constructor now requires an ID
public Student(String studentId, String name, int age, String major, double gpa) {
    this.studentId = studentId;
    this.name = name;
    setAge(age); // Validates age immediately
    // ...
}

```

### The Validation Logic

We protect our data using logic inside setters:

```java
public void setGpa(double gpa) {
    if (gpa >= 0.0 && gpa <= 4.0) {
        this.gpa = gpa;
    } else {
        System.out.println("Invalid GPA!");
        this.gpa = 0.0; // Default fallback
    }
}

```

---

## 💻 How to Run

1. **Compile the code**:
   Open your terminal or command prompt in the folder containing the files and type:
```bash
javac Student.java StudentManagementSystem.java

```


2. **Run the application**:
   Type:
```bash
java StudentManagementSystem

```



---

## 🔮 Future Improvements (Challenge Yourself!)

If you want to take this project further, try these challenges:

1. **Unique ID Check**: Modify `addStudent` to check if a Student ID already exists in the `ArrayList` before adding a new student.
2. **Persistent Storage**: Currently, data is lost when you close the program. Try saving the data to a text file (`students.txt`) so it loads when you restart the program.
3. **Search by ID**: Add a menu option to search for a student using their ID instead of their name.

