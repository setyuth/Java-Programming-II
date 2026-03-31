# ☕ Java Programming — Mid-Term Examination
# 🔑 ANSWER KEY AND MARKING GUIDE

> 🔒 **INSTRUCTOR COPY — DO NOT DISTRIBUTE TO STUDENTS**

| Field | Value |
|:---|:---|
| **Course** | Java Programming |
| **Semester** | Semester 1, Academic Year 2025 |
| **Total Marks** | 100 Points |

---

## Quick Answer Reference

### Section A — Multiple Choice

| Q1 | Q2 | Q3 | Q4 | Q5 | Q6 | Q7 | Q8 | Q9 | Q10 |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **C** | **D** | **D** | **D** | **C** | **B** | **C** | **B** | **B** | **B** |

### Section B — True / False

| Q1 | Q2 | Q3 | Q4 | Q5 | Q6 | Q7 | Q8 | Q9 | Q10 |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **T** | **F** | **F** | **T** | **T** | **T** | **F** | **T** | **T** | **T** |

### Section C — Matching

| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **A** | **B** | **C** | **D** | **E** | **F** | **G** | **H** | **I** | **J** |

---
---

# 📘 SECTION A — Multiple Choice · Detailed Answers

> **20 Points · 2 points each**

---

## Week 1 · Java Fundamentals Review

### Question 1 — Correct Answer: C `[2 pts]`

**Which of the following correctly declares an integer variable and assigns the value 10 in Java?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | `integer x = 10;` | Wrong |
| B | `Int x = 10;` | Wrong |
| **C** | **`int x = 10;`** | **CORRECT** |
| D | `x int = 10;` | Wrong |

> **Explanation:** Java primitive type names are all lowercase — `int`, `double`, `boolean`, `char`. The type always comes before the variable name. `integer` and `Int` are not valid Java keywords. Only `int` (lowercase) is a valid Java primitive.

---

### Question 2 — Correct Answer: D `[2 pts]`

**What is the output of the code?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | `B` | Wrong |
| B | `AB` | Wrong |
| C | Compilation error | Wrong |
| **D** | **`A`** | **CORRECT** |

> **Explanation:** `x = 5`, which is greater than 3, so the `if` branch executes and prints `A`. The `else` branch is skipped entirely. Only one branch executes in an `if-else` — never both.

---

## Week 2 · Object-Oriented Programming Essentials

### Question 3 — Correct Answer: D `[2 pts]`

**Which keyword is used to create an object from a class in Java?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | `create` | Wrong — not a Java keyword |
| B | `object` | Wrong — not a Java keyword |
| C | `make` | Wrong — not a Java keyword |
| **D** | **`new`** | **CORRECT** |

> **Explanation:** The `new` keyword allocates memory on the heap and calls the class constructor.
> Example: `Student s = new Student();`

---

### Question 4 — Correct Answer: D `[2 pts]`

**What is encapsulation in Java OOP?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | The ability of a class to inherit methods from a parent class | Wrong — that is Inheritance |
| B | The ability of an object to take many forms | Wrong — that is Polymorphism |
| C | Defining a method in a subclass with the same signature | Wrong — that is Method Overriding |
| **D** | **Bundling data and methods inside a class, restricting direct access** | **CORRECT** |

> **Explanation:** Encapsulation = hiding internal state using `private` fields and controlling access through `public` getters/setters. This protects data integrity and hides implementation details from the outside world.

---

## Week 3 · Inheritance and Polymorphism

### Question 5 — Correct Answer: C `[2 pts]`

**Which keyword indicates class inheritance in Java?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | `implements` | Wrong — used for interfaces |
| B | `inherits` | Wrong — not a Java keyword |
| **C** | **`extends`** | **CORRECT** |
| D | `super` | Wrong — calls parent method/constructor, does not declare inheritance |

> **Explanation:** `extends` declares class inheritance. Example: `class Dog extends Animal { }`
> Use `implements` for interfaces, use `super` to call parent class constructor or methods.

---

### Question 6 — Correct Answer: B `[2 pts]`

**What is method overriding?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | Same name, different parameters in the same class | Wrong — that is Overloading |
| **B** | **Child class provides new implementation of a parent method with the same signature** | **CORRECT** |
| C | Calling a parent method using `super` | Wrong — that is calling, not overriding |
| D | Hiding a method with `private` | Wrong — that is access control |

> **Explanation:** Overriding = subclass redefines a parent method with the identical name, parameters, and return type. It uses the `@Override` annotation and is resolved at runtime (dynamic dispatch).

---

## Week 4 · Interfaces and Java Collections Framework

### Question 7 — Correct Answer: C `[2 pts]`

**Which class allows duplicates and maintains insertion order?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | `HashSet` | Wrong — no duplicates, no order guarantee |
| B | `TreeSet` | Wrong — no duplicates, sorted order |
| **C** | **`ArrayList`** | **CORRECT** |
| D | `HashMap` | Wrong — key-value pairs, keys must be unique |

> **Explanation:** `ArrayList` is backed by a dynamic array that preserves insertion order and allows duplicates. It is the most commonly used `List` implementation in Java.

---

### Question 8 — Correct Answer: B `[2 pts]`

**Key difference between interface and abstract class?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | Interface can have constructors; abstract class cannot | Wrong — reversed, interfaces have NO constructors |
| **B** | **A class can implement multiple interfaces but only extend one class** | **CORRECT** |
| C | Abstract class cannot have methods with a body | Wrong — it can have concrete methods |
| D | Interfaces can only be used with ArrayList | Wrong — completely false |

> **Explanation:** Java supports multiple interface implementation but only single class inheritance. This is the most practically important difference. A class uses `implements` for interfaces and `extends` for classes.

---

### Question 9 — Correct Answer: B `[2 pts]`

**Which statement about `HashMap` is TRUE?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | Maintains insertion order | Wrong — use `LinkedHashMap` for that |
| **B** | **No duplicate keys, but allows duplicate values** | **CORRECT** |
| C | Only accepts `String` keys | Wrong — accepts any `Object` as key |
| D | Always sorts keys alphabetically | Wrong — use `TreeMap` for sorted keys |

> **Explanation:** Adding a duplicate key to a `HashMap` overwrites the existing value. Multiple keys can map to the same value. HashMap does not maintain insertion order.

---

### Question 10 — Correct Answer: B `[2 pts]`

**What does for-each loop yield with a `List` of `String` elements?**

| Option | Choice | Result |
|:---:|:---|:---:|
| A | Index positions `(0, 1, 2, ...)` | Wrong — use a regular `for` loop for that |
| **B** | **Each `String` element in the list, in order** | **CORRECT** |
| C | Memory addresses | Wrong — Java does not expose memory addresses |
| D | Pairs of `(index, value)` | Wrong — not possible in Java's for-each |

> **Explanation:** The enhanced for loop directly yields each element:
> ```java
> for (String s : list) { System.out.println(s); }
> ```
> For index-based access, use `list.get(i)` inside a regular `for` loop.

---
---

# 📗 SECTION B — True / False · Answers and Explanations

> **10 Points · 1 point each**

---

| No. | Statement | Answer | Explanation |
|:---:|:---|:---:|:---|
| 1 | A `final` variable cannot be reassigned after its initial value is set. | **TRUE** | `final` creates a constant. Reassigning causes a compile error. |
| 2 | The `this` keyword refers to the parent class in a subclass constructor. | **FALSE** | `this` = current object. `super` refers to the parent class. |
| 3 | An abstract class can be instantiated directly using `new`. | **FALSE** | Abstract classes cannot be instantiated — only their concrete subclasses can. |
| 4 | A Java 8+ interface can contain `default` method implementations. | **TRUE** | Java 8 introduced `default` methods with full bodies inside interfaces. |
| 5 | `ArrayList` automatically resizes when capacity is exceeded. | **TRUE** | ArrayList doubles its internal array size when it runs out of capacity. |
| 6 | A checked exception must be caught or declared with `throws`. | **TRUE** | The compiler enforces this at compile time — code will not compile otherwise. |
| 7 | `finally` executes only when no exception is thrown. | **FALSE** | `finally` ALWAYS executes — whether an exception occurred or not. |
| 8 | A `PRIMARY KEY` column enforces uniqueness and cannot be `NULL`. | **TRUE** | PRIMARY KEY = UNIQUE + NOT NULL. Both constraints are implicit. |
| 9 | `PreparedStatement` prevents SQL injection attacks. | **TRUE** | The `?` placeholders are escaped before execution, making injection impossible. |
| 10 | `ON DELETE CASCADE` deletes child rows when the parent row is deleted. | **TRUE** | The foreign key constraint propagates deletion from parent to all child rows. |

---
---

# 📙 SECTION C — Matching · Correct Answers

> **10 Points · 1 point each**

---

| No. | Term / Concept | Answer | Full Definition |
|:---:|:---|:---:|:---|
| 1 | JDBC | **A** | Java API for connecting to relational databases |
| 2 | DriverManager | **B** | Manages database driver connections in JDBC |
| 3 | PreparedStatement | **C** | A parameterised SQL statement that prevents injection |
| 4 | ResultSet | **D** | Holds rows returned by a `SELECT` query |
| 5 | `executeUpdate()` | **E** | Used for `INSERT`, `UPDATE`, `DELETE` — returns row count |
| 6 | SQLException | **F** | Exception thrown when a database error occurs |
| 7 | PRIMARY KEY | **G** | Column(s) that uniquely identify each row in a table |
| 8 | FOREIGN KEY | **H** | A column referencing the PRIMARY KEY of another table |
| 9 | ON DELETE CASCADE | **I** | Automatically removes child rows when parent row is deleted |
| 10 | DAO Pattern | **J** | Design pattern separating database code from business logic |

---
---

# 📕 SECTION D — Short Answer · Marking Scheme and Model Answers

> **30 Points · Marking breakdown shown per question**

---

## Week 1 · Java Fundamentals and Week 2 · OOP

### Question 11 `[4 pts]` — Primitive vs Reference Data Types

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | Primitive type stores the **actual value directly** in memory (stack). Names are lowercase: `int`, `double`, `boolean`, `char`, `byte`, `short`, `long`, `float`. |
| +1 | Reference type stores a **memory address (reference)** pointing to an object on the heap. Examples: `String`, arrays, any class instance. |
| +1 | Correct concrete primitive example with code (e.g., `int age = 20;`) |
| +1 | Correct concrete reference type example with code (e.g., `String name = "Alice";` or `Student s = new Student();`) |

#### Model Answer

```
Primitive types store their actual value directly in memory (stack).
There are 8 primitives: byte, short, int, long, float, double, boolean, char.

    Example:  int age = 20;    // value 20 is stored directly on the stack

Reference types store a memory address (reference) pointing to an object on the heap.
Any class, array, or String is a reference type.

    Example:  String name = "Alice";     // 'name' holds a reference to a String object
              Student s = new Student(); // 's' holds a reference to a Student object
```

---

### Question 12 `[4 pts]` — Four Access Modifiers

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | `public` — accessible from **any class in any package** |
| +1 | `protected` — accessible within the **same package** AND by **subclasses** (even in other packages) |
| +1 | `default` (no keyword) — accessible **within the same package only** (package-private) |
| +1 | `private` — accessible **only within the same class** that declared it |

#### Model Answer

```
1. public    → accessible from ANY class, ANY package (widest access)
2. protected → accessible within same package + subclasses in other packages
3. default   → (no keyword written) accessible within same package only
4. private   → accessible only inside the declaring class (most restricted)

Memory aid (widest to narrowest):
  public  >  protected  >  default  >  private
```

---

## Week 3 · Inheritance and Polymorphism

### Question 13 `[4 pts]` — Overloading vs Overriding

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | **Overloading** definition: same method name in the **same class**, but with **different parameter lists**. Resolved at compile time. |
| +1 | **Overriding** definition: subclass provides its own implementation of a parent method with the **same signature**. Resolved at runtime. |
| +1 | Correct one-line code example of overloading |
| +1 | Correct one-line code example of overriding (with `@Override` annotation) |

#### Model Answer

```java
// OVERLOADING — same class, same name, DIFFERENT parameters (compile-time):
void add(int a, int b)       { ... }
void add(double a, double b) { ... }   // different parameter types = overloading

// OVERRIDING — child class REPLACES parent method, same signature (runtime):
// In parent Animal:
public void speak() { System.out.println("..."); }

// In child Dog:
@Override
public void speak() { System.out.println("Woof!"); }
```

---

## Week 4 · Interfaces and Java Collections

### Question 14 `[3 pts]` — ArrayList vs LinkedList

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | `ArrayList` backed by dynamic array — `get(i)` is O(1). `LinkedList` backed by doubly-linked nodes — `get(i)` is O(n). |
| +1 | `ArrayList` insertion/deletion in the middle is O(n). `LinkedList` insertion/deletion at a known node is O(1). |
| +1 | When to use: `ArrayList` for frequent reads/random access; `LinkedList` for frequent insertions/deletions at the start or middle. |

#### Model Answer

```
ArrayList:
  - Backed by a resizable array
  - get(i) is O(1) — fast random access by index
  - add/remove in the middle is O(n) — elements must shift
  USE WHEN: you read elements frequently or access by index

LinkedList:
  - Backed by doubly-linked nodes (each node holds next + prev pointers)
  - get(i) is O(n) — must traverse from head
  - add/remove at head/tail is O(1) — just update pointers
  USE WHEN: you insert or delete frequently, especially at the start or middle
```

---

## Weeks 5 and 6 · Exception Handling and File I/O

### Question 15 `[3 pts]` — Checked vs Unchecked Exceptions

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | **Checked exception**: enforced by the compiler. Must be handled with `try-catch` OR declared with `throws`. Extends `Exception` (not `RuntimeException`). |
| +1 | **Unchecked exception**: NOT enforced by the compiler. Extends `RuntimeException`. Represents programming errors. |
| +1 | One correct concrete example of each type |

#### Model Answer

```java
// CHECKED EXCEPTION — compiler forces you to handle it:
// Extends Exception (not RuntimeException), must use try-catch or throws

try {
    FileReader fr = new FileReader("data.txt"); // FileNotFoundException (checked)
} catch (FileNotFoundException e) {
    System.out.println("File not found: " + e.getMessage());
}

// UNCHECKED EXCEPTION — occurs at runtime, no compile-time enforcement:
// Extends RuntimeException — represents a programming bug

int[] arr = new int[3];
arr[10] = 5;   // ArrayIndexOutOfBoundsException (unchecked)
```

---

### Question 16 `[4 pts]` — try / catch / finally

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | `try` block: wraps code that might throw an exception. Execution stops at the point where the exception is thrown. |
| +1 | `catch` block: catches a specific exception type and handles it. Multiple `catch` blocks allowed for different types. |
| +1 | `finally` block: **always executes** regardless of whether an exception occurred. Used to close resources. |
| +1 | If NOT caught: propagates up the call stack. If it reaches `main()` uncaught, the JVM terminates the program and prints the stack trace. |

#### Model Answer

```java
// try     → code that might throw an exception
// catch   → handles a specific exception if it occurs
// finally → ALWAYS runs (even if no exception) — used to close resources

try {
    int result = 10 / 0;           // throws ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("This always runs.");  // always executes
}

// If NOT caught:
// The exception propagates up the call stack from method to method.
// If it reaches main() without being caught, the JVM terminates the
// program and prints the full stack trace.
```

---

## Weeks 7 and 8 · Databases, SQL, and JDBC

### Question 17 `[4 pts]` — INNER JOIN vs LEFT JOIN

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | `INNER JOIN`: returns only rows where there is a **match in BOTH tables**. Non-matching rows are excluded. |
| +1 | `LEFT JOIN`: returns **ALL rows from the left table**, plus matched rows from the right. Non-matched right columns are `NULL`. |
| +1 | Correct scenario for `INNER JOIN` |
| +1 | Correct scenario for `LEFT JOIN` |

#### Model Answer

```sql
-- INNER JOIN — only rows that match in BOTH tables:
SELECT s.name, c.course_name
FROM students s
INNER JOIN enrollments e ON s.student_id = e.student_id;
-- Students with NO enrollments are excluded from results

-- LEFT JOIN — ALL rows from left table + matches from right (NULL if no match):
SELECT s.name, d.department_name
FROM students s
LEFT JOIN departments d ON s.department_id = d.department_id;
-- Students with NO department still appear; department_name = NULL for them

-- Use INNER JOIN when you only want records that have a relationship.
-- Use LEFT JOIN  when you want ALL records from the main table regardless.
```

---

### Question 18 `[4 pts]` — JDBC Resources to Close

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | Names all three resources: `Connection`, `PreparedStatement` (or `Statement`), `ResultSet`. |
| +1 | Correct closing order: `ResultSet` first, then `Statement/PreparedStatement`, then `Connection`. |
| +1 | Why close `ResultSet` first: it depends on the `Statement`; closing the statement first causes errors. |
| +1 | Why close `Connection` last: it is the most expensive resource; leaving it open exhausts the database connection pool. |

#### Model Answer

```
Three resources to always close:
  1. ResultSet         — holds the query result rows
  2. PreparedStatement — holds the compiled SQL statement
  3. Connection        — the database connection socket (most expensive)

Closing order:  ResultSet -> Statement -> Connection  (reverse of creation)

Why this order matters:
  - ResultSet depends on Statement; close it before closing the Statement
  - Statement depends on Connection; close it before closing the Connection
  - Connection is the most expensive resource — leaving it open exhausts
    the database connection pool and eventually crashes the application

Always close in a finally block so resources close even if an exception occurred:

    } finally {
        DatabaseConfig.closeResources(conn, pstmt, rs);
    }
```

---
---

# 📓 SECTION E — Code Writing · Model Answers and Marking Guide

> **30 Points · Marking breakdown shown per question**

---

## Week 1 · Java Fundamentals

### Question 19 `[4 pts]` — `sumArray` Method

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | Correct method signature: `public static int sumArray(int[] arr)` |
| +1 | Correct loop iterating all elements and accumulating into a `sum` variable |
| +1 | Correct `return` statement returning the sum |
| +1 | Correct `main` method with array declaration, call to `sumArray`, and result printed |

#### Model Answer

```java
public class ArraySum {

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {   // for-each loop through all elements
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 5};
        int total = sumArray(numbers);
        System.out.println("Sum: " + total);   // Output: Sum: 26
    }
}
```

> **Marking note:** Accept `for (int i = 0; i < arr.length; i++)` loop as equivalent. Deduct 1 point if the `return` statement is missing.

---

## Weeks 2 and 3 · OOP, Inheritance, and Polymorphism

### Question 20 `[8 pts]` — Animal / Dog Inheritance

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +2 | Correct `Animal` constructor: `public Animal(String name, String sound)` assigning both fields with `this.name` and `this.sound` |
| +2 | `Dog` class declared with `extends Animal` and constructor calling `super(name, sound)` |
| +2 | `@Override` annotation + `makeSound()` prints: `"Dog " + name + " says: Woof!"` correctly |
| +2 | `main` method creates `Dog` with `new Dog(...)` and calls `makeSound()` producing correct output |

#### Model Answer

```java
// Part (a): Animal Constructor
public class Animal {
    protected String name;
    protected String sound;

    public Animal(String name, String sound) {
        this.name  = name;
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(name + " says: " + sound);
    }
}

// Part (b): Dog Subclass
public class Dog extends Animal {

    public Dog(String name) {
        super(name, "Woof");    // calls the Animal constructor
    }

    @Override
    public void makeSound() {
        System.out.println("Dog " + name + " says: Woof!");
    }
}

// Part (c): main Method
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Rex");
        myDog.makeSound();      // Output: Dog Rex says: Woof!
    }
}
```

> **Marking note:** Award partial marks (1/2) for part (c) if `Dog` is constructed but `makeSound()` is not called. `@Override` annotation is expected but if omitted and the override logic is correct, still award the mark.

---

## Weeks 5 and 6 · Exception Handling

### Question 21 `[4 pts]` — `divideNumbers` with try-catch-finally

#### Marking Scheme

| Points | Expected Answer |
|:---:|:---|
| +1 | Correct method signature: `public static int divideNumbers(int a, int b)` |
| +1 | `try` block performs the division `int result = a / b;` and returns the result |
| +1 | `catch (ArithmeticException e)` block prints a meaningful error message |
| +1 | `finally` block always prints `"Operation complete."` |

#### Model Answer

```java
public class Divider {

    public static int divideNumbers(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
            return result;

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. " + e.getMessage());
            return 0;   // default value when division fails

        } finally {
            System.out.println("Operation complete.");   // always runs
        }
    }

    public static void main(String[] args) {
        divideNumbers(10, 2);   // Output: Result: 5  then  Operation complete.
        divideNumbers(10, 0);   // Output: Error message  then  Operation complete.
    }
}
```

> **Marking note:** The `finally` block must appear after `catch`, not inside it. Accept any meaningful error message for the `catch` block.

---

## Weeks 7 and 8 · SQL and JDBC

### Question 22 `[6 pts]` — SQL Query + JDBC Code

#### Marking Scheme

| Points | Part | Expected Answer |
|:---:|:---:|:---|
| +1 | (a) SQL | Correct `SELECT` of `s.student_id, s.name, s.gpa, d.department_name` |
| +1 | (a) SQL | Correct `JOIN` syntax: `JOIN departments d ON s.department_id = d.department_id` |
| +1 | (a) SQL | Correct `WHERE d.department_name = 'Computer Science'` and `ORDER BY s.gpa DESC` |
| +1 | (b) JDBC | `getConnection()` + `prepareStatement(sql)` + `pstmt.setString(1, ...)` |
| +1 | (b) JDBC | `pstmt.executeQuery()` into `ResultSet` + `while (rs.next())` loop with correct column reads |
| +1 | (b) JDBC | `closeResources` in `finally` block |

#### Model Answer — Part (a): SQL Query

```sql
SELECT s.student_id, s.name, s.gpa, d.department_name
FROM students s
JOIN departments d ON s.department_id = d.department_id
WHERE d.department_name = 'Computer Science'
ORDER BY s.gpa DESC;
```

Expected output:

| student_id | name | gpa | department_name |
|:---:|:---|:---:|:---|
| S007 | Grace Hopper | 4.00 | Computer Science |
| S001 | Alice Johnson | 3.80 | Computer Science |
| S004 | Diana Prince | 3.70 | Computer Science |

#### Model Answer — Part (b): Java JDBC Code

```java
import java.sql.*;

public class QueryCSStudents {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getConnection();

            String sql = "SELECT s.student_id, s.name, s.gpa, d.department_name " +
                         "FROM students s " +
                         "JOIN departments d ON s.department_id = d.department_id " +
                         "WHERE d.department_name = ? " +
                         "ORDER BY s.gpa DESC";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Computer Science");   // parameter index starts at 1

            rs = pstmt.executeQuery();   // executeQuery() for SELECT only

            while (rs.next()) {
                System.out.printf("%-8s  %-15s  %.2f  %s%n",
                    rs.getString("student_id"),
                    rs.getString("name"),
                    rs.getDouble("gpa"),
                    rs.getString("department_name"));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            DatabaseConfig.closeResources(conn, pstmt, rs);   // always close
        }
    }
}
```

> **Marking note:** Accept `LEFT JOIN` instead of `JOIN` — both are correct. Award partial marks (1/2) for JDBC if the `PreparedStatement` is used correctly but the `finally` block is missing.

---
---

## Marking Summary for Examiner

| Section | Full Marks | Partial Credit | Zero |
|:---:|:---|:---|:---|
| **A** | Exact answer letter matches key | — | Wrong letter or blank |
| **B** | T or F matches answer table | — | Wrong circle or blank |
| **C** | Exact letter matches key | — | Wrong letter or blank |
| **D** | All scheme points covered | Some points covered | No relevant content |
| **E** | Compiles + correct logic | Partially correct logic | No code / unrelated code |

---

**--- END OF ANSWER KEY ---**

*Java Programming Mid-Term Examination · Semester 1, 2025*

**Instructor Copy — Do Not Distribute to Students**
