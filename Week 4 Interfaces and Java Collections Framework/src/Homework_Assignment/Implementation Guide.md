# Java Programming II - Homework Assignment Guide

## Enhanced University System with LinkedList, TreeSet, and Advanced Statistics

This guide will walk you through implementing three new features for the Enhanced University System project.

---

## 📋 Table of Contents
1. [Task 1: LinkedList Feature for Attendance Tracking](#task-1-linkedlist-feature-for-attendance-tracking)
2. [Task 2: TreeSet for Sorted Names](#task-2-treeset-for-sorted-names)
3. [Task 3: Advanced Statistics](#task-3-advanced-statistics)
4. [Testing Your Implementation](#testing-your-implementation)
5. [Complete Code Files](#complete-code-files)

---

## Task 1: LinkedList Feature for Attendance Tracking

### 🎯 Objective
Track student attendance dates using Java's `LinkedList` data structure.

### 📚 Why LinkedList?
- **Efficient insertion/deletion**: Perfect for adding new attendance dates
- **Maintains order**: Keeps dates in the sequence they were added
- **Dynamic size**: Grows automatically as we add more dates

### Implementation Steps

#### Step 1: Update Student.java

Add the LinkedList import and instance variable:

```java
import java.util.LinkedList;

// Add this field to the Student class
private LinkedList<String> attendanceDates;
```

#### Step 2: Initialize in Constructor

Update the constructor to initialize the LinkedList:

```java
public Student(String name, int age, String id, String email, String major, double gpa) {
    super(name, age, id, email);
    this.major = major;
    this.gpa = gpa;
    this.enrolledCourses = new ArrayList<>();
    this.courseGrades = new HashMap<>();
    this.attendanceDates = new LinkedList<>();  // Initialize LinkedList
}
```

#### Step 3: Add Attendance Methods

Add these three methods to the `Student` class:

```java
// Mark attendance for today
public void markAttendance() {
    // Get current date in a simple format
    java.time.LocalDate today = java.time.LocalDate.now();
    String dateStr = today.toString();
    
    // Add to the beginning of the list (most recent first)
    attendanceDates.addFirst(dateStr);
    System.out.println("✓ Attendance marked for " + dateStr);
}

// Get total attendance count
public int getAttendanceCount() {
    return attendanceDates.size();
}

// Display last 5 attendance dates
public void displayAttendance() {
    System.out.println("\n--- Attendance Records ---");
    if (attendanceDates.isEmpty()) {
        System.out.println("No attendance records.");
        return;
    }
    
    System.out.println("Total attendance: " + attendanceDates.size() + " days");
    System.out.println("Recent attendance (last 5):");
    
    // Display only the first 5 entries (most recent)
    int count = Math.min(5, attendanceDates.size());
    for (int i = 0; i < count; i++) {
        System.out.println("  " + (i + 1) + ". " + attendanceDates.get(i));
    }
}
```

#### Step 4: Update displayInfo() Method

Add attendance information to the student display:

```java
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
    System.out.println("Enrolled Courses: " + enrolledCourses.size());
    System.out.println("Attendance Days: " + attendanceDates.size());  // NEW LINE

    if (!enrolledCourses.isEmpty()) {
        System.out.println("\nCourses:");
        for (String course : enrolledCourses) {
            String grade = courseGrades.get(course);
            System.out.println("  - " + course +
                    (grade != null ? " (Grade: " + grade + ")" : " (In Progress)"));
        }
    }
}
```

#### Step 5: Add Menu Options in EnhancedUniversitySystem.java

Update the menu display:

```java
public void displayMenu() {
    System.out.println("\n╔═══════════════════════════════════════╗");
    System.out.println("║   ENHANCED UNIVERSITY SYSTEM           ║");
    System.out.println("╚═══════════════════════════════════════╝");
    System.out.println("1.  Add Student");
    System.out.println("2.  Display All Students");
    System.out.println("3.  Search by Keyword");
    System.out.println("4.  Find Student by ID");
    System.out.println("5.  Display Honor Roll");
    System.out.println("6.  Enroll Student in Course");
    System.out.println("7.  Drop Student from Course");
    System.out.println("8.  Assign Grade");
    System.out.println("9.  Display Available Courses");
    System.out.println("10. Show Statistics");
    System.out.println("11. List Students by Major");
    System.out.println("12. Mark Attendance");           // NEW
    System.out.println("13. View Student Attendance");   // NEW
    System.out.println("14. Exit");
    System.out.println("─────────────────────────────────────────");
    System.out.print("Enter choice (1-14): ");
}
```

Add the attendance methods:

```java
public void markAttendance() {
    System.out.println("\n--- Mark Attendance ---");
    System.out.print("Enter Student ID: ");
    String id = scanner.nextLine();

    Person person = peopleById.get(id);
    if (person == null || !(person instanceof Student)) {
        System.out.println("✗ Student not found.");
        return;
    }

    Student student = (Student) person;
    student.markAttendance();
}

public void viewAttendance() {
    System.out.println("\n--- View Attendance ---");
    System.out.print("Enter Student ID: ");
    String id = scanner.nextLine();

    Person person = peopleById.get(id);
    if (person == null || !(person instanceof Student)) {
        System.out.println("✗ Student not found.");
        return;
    }

    Student student = (Student) person;
    System.out.println("\nStudent: " + student.getName());
    student.displayAttendance();
}
```

Update the switch statement in `run()` method:

```java
case 12: markAttendance(); break;
case 13: viewAttendance(); break;
case 14:
    System.out.println("\nThank you for using the system!");
    System.out.println("Goodbye!");
    break;
```

---

## Task 2: TreeSet for Sorted Names

### 🎯 Objective
Display students in alphabetical order using `TreeSet` and implement the `Comparable` interface.

### 📚 Why TreeSet?
- **Automatic sorting**: Maintains elements in sorted order
- **No duplicates**: Ensures unique student names
- **Efficient lookups**: O(log n) time complexity

### Implementation Steps

#### Step 1: Make Student Implement Comparable

Update the `Student` class declaration:

```java
public class Student extends Person implements Comparable<Student> {
    // ... existing code ...
}
```

Add the `compareTo` method to the `Student` class:

```java
@Override
public int compareTo(Student other) {
    // Compare students by name (alphabetically)
    int nameComparison = this.name.compareTo(other.name);
    
    // If names are the same, compare by ID to ensure uniqueness
    if (nameComparison == 0) {
        return this.id.compareTo(other.id);
    }
    
    return nameComparison;
}
```

**Understanding compareTo():**
- Returns **negative** if `this` comes before `other`
- Returns **zero** if they are equal
- Returns **positive** if `this` comes after `other`

#### Step 2: Add TreeSet Method in EnhancedUniversitySystem.java

Add the import:

```java
import java.util.TreeSet;
```

Add this method:

```java
public void displayStudentsSorted() {
    System.out.println("\n--- Students (Alphabetically Sorted) ---");
    
    if (students.isEmpty()) {
        System.out.println("No students in system.");
        return;
    }

    // Create TreeSet - automatically sorts using compareTo()
    TreeSet<Student> sortedStudents = new TreeSet<>(students);

    int count = 1;
    for (Student student : sortedStudents) {
        System.out.println("\n" + count + ". " + student.getName());
        System.out.println("   ID: " + student.getId());
        System.out.println("   Major: " + student.getMajor());
        System.out.println("   GPA: " + student.getGpa());
        System.out.println("   Attendance: " + student.getAttendanceCount() + " days");
        count++;
    }
    
    System.out.println("\nTotal students: " + sortedStudents.size());
}
```

#### Step 3: Add to Menu

Update the menu:

```java
System.out.println("15. Display Students (Sorted by Name)");  // NEW
System.out.println("16. Exit");
```

Add to switch statement:

```java
case 15: displayStudentsSorted(); break;
case 16:
    System.out.println("\nThank you for using the system!");
    System.out.println("Goodbye!");
    break;
```

---

## Task 3: Advanced Statistics

### 🎯 Objective
Add comprehensive statistical analysis features to the system.

### Implementation Steps

#### Add the Advanced Statistics Method

Add this comprehensive method to `EnhancedUniversitySystem.java`:

```java
public void showAdvancedStatistics() {
    System.out.println("\n╔═══════════════════════════════════════╗");
    System.out.println("║      ADVANCED STATISTICS              ║");
    System.out.println("╚═══════════════════════════════════════╝");

    if (students.isEmpty()) {
        System.out.println("No data available.");
        return;
    }

    // 1. Find student with highest/lowest GPA
    Student highestGPA = students.get(0);
    Student lowestGPA = students.get(0);

    for (Student student : students) {
        if (student.getGpa() > highestGPA.getGpa()) {
            highestGPA = student;
        }
        if (student.getGpa() < lowestGPA.getGpa()) {
            lowestGPA = student;
        }
    }

    System.out.println("\n📊 GPA Analysis:");
    System.out.println("Highest GPA: " + highestGPA.getName() + 
                       " (" + highestGPA.getGpa() + ")");
    System.out.println("Lowest GPA: " + lowestGPA.getName() + 
                       " (" + lowestGPA.getGpa() + ")");

    // 2. Calculate grade distribution
    HashMap<String, Integer> gradeDistribution = new HashMap<>();
    gradeDistribution.put("A", 0);
    gradeDistribution.put("B", 0);
    gradeDistribution.put("C", 0);
    gradeDistribution.put("D", 0);
    gradeDistribution.put("F", 0);

    int totalGrades = 0;
    for (Student student : students) {
        for (String course : student.getEnrolledCourses()) {
            // This requires adding a getter method in Student class
            String grade = student.getGrade(course);
            if (grade != null) {
                gradeDistribution.put(grade, 
                    gradeDistribution.getOrDefault(grade, 0) + 1);
                totalGrades++;
            }
        }
    }

    if (totalGrades > 0) {
        System.out.println("\n📈 Grade Distribution:");
        for (String grade : new String[]{"A", "B", "C", "D", "F"}) {
            int count = gradeDistribution.get(grade);
            double percentage = (count * 100.0) / totalGrades;
            System.out.println("  " + grade + ": " + count + 
                             " (" + String.format("%.1f%%", percentage) + ")");
        }
    }

    // 3. Find most enrolled course
    HashMap<String, Integer> courseEnrollment = new HashMap<>();
    for (Student student : students) {
        for (String course : student.getEnrolledCourses()) {
            courseEnrollment.put(course, 
                courseEnrollment.getOrDefault(course, 0) + 1);
        }
    }

    if (!courseEnrollment.isEmpty()) {
        String mostPopular = "";
        int maxEnrollment = 0;
        
        for (String course : courseEnrollment.keySet()) {
            int count = courseEnrollment.get(course);
            if (count > maxEnrollment) {
                maxEnrollment = count;
                mostPopular = course;
            }
        }

        System.out.println("\n🎓 Most Enrolled Course:");
        System.out.println("  " + mostPopular + " (" + maxEnrollment + " students)");
    }

    // 4. Students with no course enrollments
    ArrayList<Student> noEnrollments = new ArrayList<>();
    for (Student student : students) {
        if (student.getEnrolledCourses().isEmpty()) {
            noEnrollments.add(student);
        }
    }

    System.out.println("\n⚠️  Students with No Enrollments: " + noEnrollments.size());
    if (!noEnrollments.isEmpty()) {
        for (Student student : noEnrollments) {
            System.out.println("  • " + student.getName() + " (" + student.getId() + ")");
        }
    }

    // 5. Calculate average courses per student
    int totalEnrollments = 0;
    for (Student student : students) {
        totalEnrollments += student.getEnrolledCourses().size();
    }
    double avgCourses = (double) totalEnrollments / students.size();

    System.out.println("\n📚 Course Enrollment Statistics:");
    System.out.println("Total enrollments: " + totalEnrollments);
    System.out.println("Average courses per student: " + 
                       String.format("%.2f", avgCourses));
}
```

#### Add Helper Method in Student.java

Add this public getter method to access course grades:

```java
public String getGrade(String course) {
    return courseGrades.get(course);
}
```

#### Update Menu

Add to menu display:

```java
System.out.println("17. Advanced Statistics");  // NEW
System.out.println("18. Exit");
```

Add to switch statement:

```java
case 17: showAdvancedStatistics(); break;
case 18:
    System.out.println("\nThank you for using the system!");
    System.out.println("Goodbye!");
    break;
```

---

## Testing Your Implementation

### Test Scenario 1: Attendance Tracking

1. Add a student
2. Mark attendance (option 12) - do this 6-7 times
3. View attendance (option 13) - should show last 5 dates
4. Display student info (option 2) - should show attendance count

### Test Scenario 2: Sorted Display

1. Add multiple students with different names (try: "Zara", "Alice", "Mike", "Bob")
2. Select option 15 (Display Students Sorted)
3. Verify they appear alphabetically

### Test Scenario 3: Advanced Statistics

1. Add 4-5 students with varying GPAs
2. Enroll students in different courses
3. Assign various grades (A, B, C, D, F)
4. Select option 17 (Advanced Statistics)
5. Verify all statistics are calculated correctly

---

## Complete Code Files## 📝 Summary of Changes

### Files Modified:
1. **Student.java** - Added LinkedList for attendance, implemented Comparable interface, added helper methods
2. **EnhancedUniversitySystem.java** - Added 4 new menu options and corresponding methods

### New Features Added:
- ✅ **Attendance tracking** with LinkedList (stores dates, displays last 5)
- ✅ **Alphabetical sorting** using TreeSet and Comparable
- ✅ **Advanced statistics** including GPA analysis, grade distribution, popular courses, and more

---

## 🚀 How to Run

1. Make sure all files are in the `HANDS_ON_PROJECT` package
2. Compile all Java files
3. Run `EnhancedUniversitySystem.java`
4. Test each new feature using the menu options 12-15

---

## 📊 Expected Output Examples

### Attendance Tracking:
```
--- Attendance Records ---
Total attendance: 7 days
Recent attendance (last 5):
  1. 2026-01-26
  2. 2026-01-25
  3. 2026-01-24
  4. 2026-01-23
  5. 2026-01-22
```

### Sorted Display:
```
--- Students (Alphabetically Sorted) ---

1. Alice Johnson
   ID: S001
   Major: Computer Science
   GPA: 3.8
   Attendance: 5 days

2. Bob Smith
   ID: S002
   Major: Mathematics
   GPA: 3.2
   Attendance: 3 days
```

### Advanced Statistics:
```
╔═══════════════════════════════════════╗
║      ADVANCED STATISTICS              ║
╚═══════════════════════════════════════╝

📊 GPA Analysis:
Highest GPA: Alice Johnson (3.8)
Lowest GPA: Bob Smith (3.2)

📈 Grade Distribution:
  A: 5 (41.7%)
  B: 4 (33.3%)
  C: 2 (16.7%)
  D: 1 (8.3%)
  F: 0 (0.0%)
```

---

## 🎓 Learning Objectives Achieved

1. **LinkedList Usage**: Efficient insertion and maintaining order
2. **TreeSet Implementation**: Automatic sorting and duplicate prevention
3. **Comparable Interface**: Custom object comparison for sorting
4. **Advanced Data Processing**: HashMap for aggregation and statistical analysis
5. **Code Organization**: Clean separation of concerns and maintainable code

## 📚 Additional Resources

- [Java LinkedList Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
- [Java TreeSet Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html)
- [Comparable Interface Guide](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)

---

**Good luck with your homework! 🎉**

If you have questions, feel free to open an issue on the GitHub repository.