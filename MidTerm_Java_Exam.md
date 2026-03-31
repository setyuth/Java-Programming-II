# ☕ Java Programming — Mid-Term Examination

---

## 🎓 Semester 1 · Academic Year 2025

| Field | Value |
|:---|:---|
| **Course** | Java Programming |
| **Duration** | 2 Hours (120 minutes) |
| **Total Marks** | 100 Points |
| **Covers** | Weeks 1 – 8 |

---

## 📝 Student Information

| Field | Answer |
|:---|:---|
| **Student Name** | `________________________________________________` |
| **Student ID** | `________________________________________________` |
| **Date** | `________________________________________________` |
| **Section / Class** | `________________________________________________` |

---

## 📋 Exam Instructions

> ⚠️ **Read carefully before you begin.**

1. Write your **full name** and **Student ID** clearly above.
2. This exam has **5 sections** covering Weeks 1–8. Read each section heading carefully.
3. **Multiple Choice** — select **ONE** answer only per question.
4. **True / False** — circle **T** or **F** for each statement.
5. **Short Answer** — write concise, clear answers in the spaces provided.
6. **Code Writing** — write syntactically correct Java code. Indentation is expected.
7. **No** mobile phones, smart watches, or electronic devices.
8. **Calculators are NOT permitted.**
9. Manage your time wisely — attempt all sections before time is called.

---

## 🏆 Score Summary *(Examiner Use Only)*

| Section | Topic Coverage | Max | Score |
|:---:|:---|:---:|:---:|
| **A** | Multiple Choice — Weeks 1–4 | 20 | |
| **B** | True / False — Weeks 1–8 | 10 | |
| **C** | Matching — Weeks 5–8 | 10 | |
| **D** | Short Answer — Weeks 1–8 | 30 | |
| **E** | Code Writing — Weeks 1–8 | 30 | |
| | **TOTAL** | **100** | |

---
---

# 📘 SECTION A — Multiple Choice

> **20 Points · 2 points each · Circle the letter of the ONE best answer.**

---

## Week 1 · Java Fundamentals Review

### Question 1 `[2 pts]`

**Which of the following correctly declares an integer variable and assigns the value 10 in Java?**

- [ ] A) `integer x = 10;`
- [ ] B) `Int x = 10;`
- [ ] C) `int x = 10;`
- [ ] D) `x int = 10;`

---

### Question 2 `[2 pts]`

**What is the output of the following code?**

```java
int x = 5;
if (x > 3) {
    System.out.println("A");
} else {
    System.out.println("B");
}
```

- [ ] A) `B`
- [ ] B) `AB`
- [ ] C) Compilation error
- [ ] D) `A`

---

## Week 2 · Object-Oriented Programming Essentials

### Question 3 `[2 pts]`

**Which keyword is used to create an object from a class in Java?**

- [ ] A) `create`
- [ ] B) `object`
- [ ] C) `make`
- [ ] D) `new`

---

### Question 4 `[2 pts]`

**What is encapsulation in Java OOP?**

- [ ] A) The ability of a class to inherit methods from a parent class
- [ ] B) The ability of an object to take many forms
- [ ] C) Defining a method in a subclass with the same signature as in the parent class
- [ ] D) Bundling data (fields) and methods inside a single class, and restricting direct access from outside

---

## Week 3 · Inheritance and Polymorphism

### Question 5 `[2 pts]`

**Which keyword is used in Java to indicate that a class inherits from another class?**

- [ ] A) `implements`
- [ ] B) `inherits`
- [ ] C) `extends`
- [ ] D) `super`

---

### Question 6 `[2 pts]`

**What is method overriding?**

- [ ] A) Defining two methods in the same class with the same name but different parameters
- [ ] B) Providing a new implementation of a parent class method in the child class with the same signature
- [ ] C) Calling a method from the parent class using the `super` keyword
- [ ] D) Hiding a method from outside classes using the `private` access modifier

---

## Week 4 · Interfaces and Java Collections Framework

### Question 7 `[2 pts]`

**Which Java Collections class allows duplicate elements and maintains insertion order?**

- [ ] A) `HashSet`
- [ ] B) `TreeSet`
- [ ] C) `ArrayList`
- [ ] D) `HashMap`

---

### Question 8 `[2 pts]`

**What is the key difference between an interface and an abstract class in Java?**

- [ ] A) An interface can have constructors; an abstract class cannot
- [ ] B) A class can implement multiple interfaces but can only extend one class
- [ ] C) An abstract class cannot have any methods with a body
- [ ] D) Interfaces can only be used with the `ArrayList` collection

---

### Question 9 `[2 pts]`

**Which statement about `HashMap` is TRUE?**

- [ ] A) `HashMap` maintains the insertion order of keys
- [ ] B) `HashMap` does not allow duplicate keys but allows duplicate values
- [ ] C) `HashMap` only accepts `String` keys
- [ ] D) `HashMap` always sorts keys alphabetically

---

### Question 10 `[2 pts]`

**What does the for-each loop yield when used with a `List` of `String` elements?**

- [ ] A) The index positions `(0, 1, 2, ...)`
- [ ] B) Each `String` element in the list, in order
- [ ] C) The memory addresses of each element
- [ ] D) Pairs of `(index, value)` at the same time

---

**Section A Score: _______ / 20**

---
---

# 📗 SECTION B — True / False

> **10 Points · 1 point each · Circle T for True or F for False.**

---

| No. | Statement | Answer |
|:---:|:---|:---:|
| 1 | In Java, a variable declared with the `final` keyword cannot be reassigned after its initial value is set. | T / F |
| 2 | The `this` keyword refers to the parent class in a subclass constructor. | T / F |
| 3 | An abstract class can be instantiated directly using the `new` keyword. | T / F |
| 4 | A Java interface declared with Java 8+ can contain `default` method implementations with a body. | T / F |
| 5 | `ArrayList` in Java automatically resizes when elements are added beyond its current capacity. | T / F |
| 6 | A checked exception in Java must be either caught with `try-catch` or declared with the `throws` keyword. | T / F |
| 7 | The `finally` block in a `try-catch-finally` statement executes only when no exception is thrown. | T / F |
| 8 | In SQL, a `PRIMARY KEY` column automatically enforces uniqueness and cannot contain `NULL` values. | T / F |
| 9 | `PreparedStatement` in JDBC is safer than `Statement` because it prevents SQL injection attacks. | T / F |
| 10 | The `ON DELETE CASCADE` constraint means that deleting a parent row also deletes all related child rows. | T / F |

---

**Section B Score: _______ / 10**

---
---

# 📙 SECTION C — Matching

> **10 Points · 1 point each · Write the letter of the correct definition in the blank.**

---

**Column A — Terms / Concepts**

| No. | Term / Concept | Answer |
|:---:|:---|:---:|
| 1 | JDBC | `___` |
| 2 | DriverManager | `___` |
| 3 | PreparedStatement | `___` |
| 4 | ResultSet | `___` |
| 5 | `executeUpdate()` | `___` |
| 6 | SQLException | `___` |
| 7 | PRIMARY KEY | `___` |
| 8 | FOREIGN KEY | `___` |
| 9 | ON DELETE CASCADE | `___` |
| 10 | DAO Pattern | `___` |

**Column B — Definitions**

| Letter | Definition |
|:---:|:---|
| A | Java API for connecting to relational databases |
| B | Manages database driver connections in JDBC |
| C | A parameterised SQL statement that prevents injection |
| D | Holds rows returned by a `SELECT` query |
| E | Used for `INSERT`, `UPDATE`, `DELETE` — returns row count |
| F | Exception thrown when a database error occurs |
| G | Column(s) that uniquely identify each row in a table |
| H | A column that references the PRIMARY KEY of another table |
| I | Automatically removes child rows when parent row is deleted |
| J | Design pattern separating database code from business logic |

---

**Section C Score: _______ / 10**

---
---

# 📕 SECTION D — Short Answer

> **30 Points · Points shown per question · Write answers in the spaces provided.**

---

## Week 1 · Java Fundamentals and Week 2 · OOP

### Question 11 `[4 pts]`

**Explain the difference between a *primitive* data type and a *reference* data type in Java. Give one example of each.**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

### Question 12 `[4 pts]`

**What are the four access modifiers in Java? Briefly describe the access level each one provides.**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

## Week 3 · Inheritance and Polymorphism

### Question 13 `[4 pts]`

**What is the difference between method *overloading* and method *overriding*? Give a one-line code example of each.**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

## Week 4 · Interfaces and Java Collections

### Question 14 `[3 pts]`

**Describe TWO differences between `ArrayList` and `LinkedList` in Java. When would you choose one over the other?**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

## Weeks 5 and 6 · Exception Handling and File I/O

### Question 15 `[3 pts]`

**Explain what *checked* exceptions and *unchecked* exceptions are in Java. Give one example of each type.**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

### Question 16 `[4 pts]`

**Describe the role of `try`, `catch`, and `finally` blocks. What happens if an exception is NOT caught?**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

## Weeks 7 and 8 · Databases, SQL, and JDBC

### Question 17 `[4 pts]`

**What is the difference between `INNER JOIN` and `LEFT JOIN` in SQL? Give a scenario where you would use each one.**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

### Question 18 `[4 pts]`

**Describe the three JDBC resources that must always be closed after a database operation. In what order should they be closed, and why?**

```
Answer:




____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________

____________________________________________________________________________
```

---

**Section D Score: _______ / 30**

---
---

# 📓 SECTION E — Code Writing

> **30 Points · Points shown per question · Write correct, complete Java code.**
> Proper indentation and syntax are expected.

---

## Week 1 · Java Fundamentals

### Question 19 `[4 pts]`

**Write a Java method called `sumArray` that accepts an `int[]` array as a parameter and returns the sum of all elements. Show a sample call inside a `main` method.**

```java
// Write your code here:




```

```java




```

---

## Weeks 2 and 3 · OOP, Inheritance, and Polymorphism

### Question 20 `[8 pts]`

**Consider the starter code below. Complete the code by:**

- **(a)** Adding a constructor to `Animal` that sets `name` and `sound`
- **(b)** Writing the `Dog` subclass that `extends Animal` and overrides `makeSound()` to print: `"Dog [name] says: Woof!"`
- **(c)** Writing a `main` method that creates a `Dog` object and calls `makeSound()`

**Starter code (given — do not rewrite this):**

```java
public class Animal {
    protected String name;
    protected String sound;

    // TODO (a): write the constructor here


    public void makeSound() {
        System.out.println(name + " says: " + sound);
    }
}
```

**Write your `Dog` subclass and `main` method below:**

```java
// Dog subclass — Part (b):




```

```java
// main method — Part (c):




```

---

## Weeks 5 and 6 · Exception Handling

### Question 21 `[4 pts]`

**Write a Java method called `divideNumbers(int a, int b)` that divides `a` by `b` and returns the result. The method must:**

- **(a)** Catch `ArithmeticException` if `b` is 0 and print a meaningful error message
- **(b)** Use a `finally` block that **always** prints `"Operation complete."`

```java
// Write your code here:




```

```java




```

---

## Weeks 7 and 8 · SQL and JDBC

### Question 22 `[6 pts]`

**Using the `university_db` schema (`students` and `departments` tables), write:**

- **(a)** A SQL query to select all students in the `'Computer Science'` department, showing `student_id`, `name`, `gpa`, and `department_name`. Order results by `gpa` descending.
- **(b)** The equivalent Java JDBC code using `PreparedStatement` to run that query and print each row to the console.

**Part (a) — SQL Query:**

```sql
-- Write your SQL here:



```

**Part (b) — Java JDBC Code:**

```java
// Write your Java JDBC code here:




```

```java




```

---

**Section E Score: _______ / 30**

---
---

## Final Score Summary

| Section | A | B | C | D | E | Total |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| **Score** | /20 | /10 | /10 | /30 | /30 | **/100** |

---

**--- END OF EXAMINATION ---**

*Please check that you have answered all questions before submitting your paper.*

**Java Programming Mid-Term Examination · Semester 1, 2025**
