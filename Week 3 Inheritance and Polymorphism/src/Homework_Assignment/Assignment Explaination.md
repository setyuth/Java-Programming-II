# 🎓 Enhanced University Management System

A Hands-On Java Project demonstrating **Inheritance**, **Polymorphism**, and **Object Composition**.

![Java](https://img.shields.io/badge/Language-Java-orange) ![Level](https://img.shields.io/badge/Level-Intermediate-blue) ![Status](https://img.shields.io/badge/Status-Educational-green)

## 📖 Project Overview
This project is an enhancement of a standard Student Management System. It manages different types of people (Students, Teachers, Admins) within a university context.

**Key Learning Goals:**
1.  **Inheritance:** Extending functionality (e.g., `GraduateStudent` extends `Student`).
2.  **Polymorphism (Overriding):** Changing how a subclass behaves (e.g., changing `getAcademicStatus`).
3.  **Method Overloading:** Creating multiple versions of a single method (e.g., `addCredits`).
4.  **Composition:** Building complex objects from simpler ones (e.g., A `Department` has a list of `Teachers`).

---

## 📂 Project Structure

| File | Description | Key Concept |
| :--- | :--- | :--- |
| **`Homework_Assignment/Person.java`** | The abstract base class for all people. | Abstraction |
| **`Homework_Assignment/Task2/Student.java`** | Represents an undergraduate. Extends `Person`. | Inheritance |
| **`Homework_Assignment/Task1/GraduateStudent.java`** | **(New)** Represents a grad student. Extends `Student`. | Multilevel Inheritance |
| **`Homework_Assignment/Teacher.java`** | Represents a faculty member. Extends `Person`. | Inheritance |
| **`Homework_Assignment/Admin.java`** | Represents staff users. Extends `Person`. | Inheritance |
| **`Homework_Assignment/Task3/Department.java`** | **(New)** Manages a group of Teachers. | Composition (Has-A) |
| **`Homework_Assignment/UniversityManagementSystem.java`** | The main application containing the menu and logic. | Control Flow |

---

## 🚀 New Features Explained

### 1. The Graduate Student (Inheritance)
We created a specialized class called `GraduateStudent`.
* **Why?** They are students, but they have extra data (Thesis, Advisor).
* **How it works:** It extends `Student`, meaning it gets `name`, `id`, `gpa`, etc., for free!
* **Unique Feature:** It overrides `getAcademicStatus()` to strictly return "Graduate Student" instead of Freshman/Senior.

### 2. Flexible Credit System (Method Overloading)
In `Student.java`, the `addCredits` method can now be called in **3 different ways**:

```java
student.addCredits(3);                       // 1. Just adds credits
student.addCredits(3, "History 101");        // 2. Adds credits + logs course name
student.addCredits(4, "Physics", 'A');       // 3. Adds credits + logs course & grade

```

*Note: Java automatically picks the correct method based on the arguments you pass.*

### 3. Department Management (Composition)

The `Department` class is a standalone helper.

* It is **NOT** a Person.
* It **HAS A** list of Teachers.
* It performs calculations like `calculateAverageSalary()` for that specific department.

---

## 🛠️ How to Run the Project

### Prerequisites

* Java Development Kit (JDK) 8 or higher.
* A terminal or command prompt.

### Compilation

Navigate to the folder containing the files and run:

```bash
javac -d . *.java
```

### Execution

Run the main system:

```bash
java Homework_Assignment/UniversityManagementSystem
```

---

## 🧪 Self-Study Challenges

Try to answer these questions by reading the code:

1. **Inheritance:** Look at `GraduateStudent.java`. Why do we need to call `super(...)` inside the constructor? What happens if you remove it?
2. **Polymorphism:** If you create a `GraduateStudent` object but store it in a `Person` variable (e.g., `Person p = new GraduateStudent(...)`), which version of `displayInfo()` gets called? The one in Person, Student, or GraduateStudent?
3. **Logic:** In `Student.java`, look at the `addCredits` methods. How does the system prevent negative credits from being added?

---

## 📝 Example Usage Scenario

1. **Start the App.**
2. Select **Option 1 (Add Student)**.
3. Type **'y'** when asked if it is a Graduate Student.
4. Enter details (Thesis Title, Advisor).
5. Select **Option 8 (Thesis Defense)** and enter the Student ID you just created.
6. See how the system handles the specific Graduate data!

---

**Happy Coding!** 💻