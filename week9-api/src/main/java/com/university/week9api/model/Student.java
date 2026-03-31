package com.university.week9api.model;

/**
 * Student — model class representing a student resource.
 *
 * Spring Boot (Jackson) converts this class to JSON automatically.
 * IMPORTANT: Jackson reads getter methods to build the JSON.
 *            Every field that should appear in JSON MUST have a getter.
 *
 * JSON output example:
 * {
 *   "id": 1,
 *   "name": "Alice Johnson",
 *   "age": 20,
 *   "major": "Computer Science",
 *   "gpa": 3.8
 * }
 */
public class Student {
    private int    id;
    private String name;
    private int    age;
    private String major;
    private double gpa;

    // ── No-arg constructor — required by Jackson for JSON deserialization ───
    // When a POST request arrives with JSON body, Jackson needs this
    // constructor to create a Student object before filling in the fields.
    public Student() {}

    // ── All-args constructor — used when we create sample data ──────────────
    public Student(int id, String name, int age, String major, double gpa) {
        this.id    = id;
        this.name  = name;
        this.age   = age;
        this.major = major;
        this.gpa   = gpa;
    }

    // ── Getters — Jackson reads these to produce JSON ────────────────────────
    public int    getId()    { return id; }
    public String getName()  { return name; }
    public int    getAge()   { return age; }
    public String getMajor() { return major; }
    public double getGpa()   { return gpa; }

    // ── Setters — Jackson uses these when reading JSON from a POST body ───────
    public void setId(int id)       { this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setAge(int age)     { this.age = age; }
    public void setMajor(String major){ this.major = major; }
    public void setGpa(double gpa)  { this.gpa = gpa; }

    @Override
    public String toString() {
        return String.format("Student[id=%d, name=%s, age=%d, major=%s, gpa=%.2f]",
                id, name, age, major, gpa);
    }
}
