package com.university.jdbc.model;

/**
 * Student — represents one row from theWeek 7 'students' table.
 *
 * Column mapping (Java field → database column):
 *   studentId      → student_id
 *   name           → name
 *   age            → age
 *   email          → email
 *   phone          → phone           (nullable)
 *   major          → major
 *   gpa            → gpa
 *   departmentId   → department_id   (foreign key to departments)
 *   enrollmentDate → enrollment_date (set automatically by PostgreSQL DEFAULT)
 *   departmentName → department_name (comes from JOIN with departments table)
 */
public class Student {

    private String studentId;
    private String name;
    private int    age;
    private String email;
    private String phone;           // nullable — not all students have a phone on file
    private String major;
    private double gpa;
    private int    departmentId;    // foreign key — links to departments table
    private String enrollmentDate;  // stored as String for easy display
    private String departmentName;  // populated from LEFT JOIN with departments

    // ── Constructor for INSERT (enrollment_date set by PostgreSQL DEFAULT) ───
    public Student(String studentId, String name, int age, String email,
                   String phone, String major, double gpa, int departmentId) {
        this.studentId    = studentId;
        this.name         = name;
        this.age          = age;
        this.email        = email;
        this.phone        = phone;
        this.major        = major;
        this.gpa          = gpa;
        this.departmentId = departmentId;
    }

    // ── Constructor for SELECT (all fields including date and joined name) ───
    public Student(String studentId, String name, int age, String email,
                   String phone, String major, double gpa, int departmentId,
                   String enrollmentDate, String departmentName) {
        this.studentId      = studentId;
        this.name           = name;
        this.age            = age;
        this.email          = email;
        this.phone          = phone;
        this.major          = major;
        this.gpa            = gpa;
        this.departmentId   = departmentId;
        this.enrollmentDate = enrollmentDate;
        this.departmentName = departmentName;
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public String getStudentId()       { return studentId; }
    public String getName()            { return name; }
    public int    getAge()             { return age; }
    public String getEmail()           { return email; }
    public String getPhone()           { return phone; }
    public String getMajor()           { return major; }
    public double getGpa()             { return gpa; }
    public int    getDepartmentId()    { return departmentId; }
    public String getEnrollmentDate()  { return enrollmentDate; }
    public String getDepartmentName()  { return departmentName; }

    // ── Setters ──────────────────────────────────────────────────────────────
    public void setStudentId(String studentId)          { this.studentId = studentId; }
    public void setName(String name)                    { this.name = name; }
    public void setAge(int age)                         { this.age = age; }
    public void setEmail(String email)                  { this.email = email; }
    public void setPhone(String phone)                  { this.phone = phone; }
    public void setMajor(String major)                  { this.major = major; }
    public void setGpa(double gpa)                      { this.gpa = gpa; }
    public void setDepartmentId(int departmentId)       { this.departmentId = departmentId; }
    public void setEnrollmentDate(String enrollmentDate){ this.enrollmentDate = enrollmentDate; }
    public void setDepartmentName(String departmentName){ this.departmentName = departmentName; }

    // ── toString ─────────────────────────────────────────────────────────────
    @Override
    public String toString() {
        return String.format(
                "Student[ID=%-6s  Name=%-15s  Age=%-3d  Major=%-20s  GPA=%.2f  Dept=%s]",
                studentId, name, age, major, gpa,
                (departmentName != null ? departmentName : "dept_id=" + departmentId)
        );
    }
}