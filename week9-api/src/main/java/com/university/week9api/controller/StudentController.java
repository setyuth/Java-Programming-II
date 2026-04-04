package com.university.week9api.controller;

import com.university.week9api.model.ApiResponse;
import com.university.week9api.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StudentController — full CRUD REST API for students.
 *
 * Base URL: /api/students
 *
 * Endpoints:
 *   GET    /api/students              → all students
 *   GET    /api/students/{id}         → one student by ID
 *   GET    /api/students?major=...    → filter by major
 *   GET    /api/students/count        → total count
 *   POST   /api/students              → add new student
 *   PUT    /api/students/{id}         → update entire student
 *   DELETE /api/students/{id}         → delete student
 *
 * Data storage: in-memory ArrayList (no database this week).
 * NOTE: data resets every time the server restarts.
 * Database integration comes in Week 11.
 *
 * New annotation this week:
 *   @RequestBody   = reads the JSON body of a POST/PUT request
 *                    and converts it into a Java object automatically
 *   ResponseEntity = lets you set the HTTP status code on the response
 *                    (e.g. 201 Created instead of default 200 OK)
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    // ── In-memory data store ─────────────────────────────────────────────────
    // This replaces the database for now.
    // Using the same data as university_db Week 6 sample data.
    private final List<Student> students = new ArrayList<>();
    private int nextId = 9;   // next ID to assign when a new student is added

    // ── Constructor: load sample data matching Week 6 university_db ──────────
    public StudentController() {
        students.add(new Student(1, "Alice Johnson", 20, "Computer Science", 3.8));
        students.add(new Student(2, "Bob Smith",     22, "Mathematics",      3.5));
        students.add(new Student(3, "Charlie Brown", 21, "Physics",          3.9));
        students.add(new Student(4, "Diana Prince",  20, "Computer Science", 3.7));
        students.add(new Student(5, "Eve Wilson",    23, "Chemistry",        3.6));
        students.add(new Student(6, "Frank Castle",  24, "Engineering",      3.4));
        students.add(new Student(7, "Grace Hopper",  19, "Computer Science", 4.0));
        students.add(new Student(8, "Henry Ford",    21, "Engineering",      3.3));
    }

    // ════════════════════════════════════════════════════════════════════════
    //  GET — Read operations
    // ════════════════════════════════════════════════════════════════════════

    /**
     * GET /api/students
     * GET /api/students?major=Computer+Science
     *
     * Returns all students, or filters by major if the query param is provided.
     * ResponseEntity lets us control the HTTP status code (200 OK here).
     */
    @GetMapping
    public ResponseEntity<ApiResponse> getAllStudents(
            @RequestParam(required = false) String major) {

        List<Student> result;

        if (major != null && !major.isEmpty()) {
            // Filter by major — case-insensitive partial match
            result = students.stream()
                    .filter(s -> s.getMajor().toLowerCase()
                            .contains(major.toLowerCase()))
                    .collect(Collectors.toList());

            if (result.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("No students found in major: " + major));
            }
            return ResponseEntity.ok(
                    ApiResponse.ok("Found " + result.size() + " student(s) in: " + major, result));
        }

        // No filter — return everyone
        return ResponseEntity.ok(
                ApiResponse.ok("Found " + students.size() + " student(s)", students));
    }

    /**
     * GET /api/students/count
     *
     * Returns the total number of students.
     * NOTE: This mapping MUST be placed BEFORE /{id} in the code,
     * otherwise Spring will try to parse "count" as an integer ID.
     */
    @GetMapping("/count")
    public ResponseEntity<ApiResponse> getStudentCount() {
        return ResponseEntity.ok(
                ApiResponse.ok("Total students: " + students.size(), students.size()));
    }

    /**
     * GET /api/students/{id}
     *
     * Returns one student by their integer ID.
     * Returns 404 Not Found if no student has that ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStudentById(@PathVariable int id) {

        Optional<Student> found = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();

        if (found.isPresent()) {
            return ResponseEntity.ok(
                    ApiResponse.ok("Student found", found.get()));
        } else {
            // 404 Not Found — the student does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("No student found with ID: " + id));
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  POST — Create operation
    // ════════════════════════════════════════════════════════════════════════

    /**
     * POST /api/students
     * Body: { "name": "New Student", "age": 21, "major": "Physics", "gpa": 3.5 }
     *
     * @RequestBody reads the JSON request body and converts it to a Student object.
     * Returns 201 Created (not the default 200 OK) to follow REST conventions.
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addStudent(@RequestBody Student student) {

        try {

            // Validate required fields

            if (student.getName() == null || student.getName().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.error("Student name is required."));
            }
            if (student.getMajor() == null || student.getMajor().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.error("Student major is required."));
            }
            if (student.getGpa() < 0.0 || student.getGpa() > 4.0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.error("GPA must be between 0.0 and 4.0."));
            }

            // Assign the next ID automatically
            student.setId(nextId++);
            students.add(student);

            // Return 201 Created with the newly added student
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.ok("Student added successfully!", student));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  PUT — Update operation
    // ════════════════════════════════════════════════════════════════════════

    /**
     * PUT /api/students/{id}
     * Body: { "name": "Updated Name", "age": 22, "major": "Engineering", "gpa": 3.6 }
     *
     * Updates ALL fields of the student with the given ID.
     * Returns 404 if the student is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                // Preserve the original ID — do not let the client change it
                updatedStudent.setId(id);
                students.set(i, updatedStudent);

                return ResponseEntity.ok(
                        ApiResponse.ok("Student updated successfully!", updatedStudent));
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("No student found with ID: " + id));
    }

    // ════════════════════════════════════════════════════════════════════════
    //  DELETE — Remove operation
    // ════════════════════════════════════════════════════════════════════════

    /**
     * DELETE /api/students/{id}
     *
     * Removes the student with the given ID from the list.
     * Returns 404 if the student is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable int id) {

        Optional<Student> found = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();

        if (found.isPresent()) {
            students.remove(found.get());
            return ResponseEntity.ok(
                    ApiResponse.ok("Student with ID " + id + " deleted successfully."));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("No student found with ID: " + id));
    }
}