package HANDS_ON_PROJECT;

import HANDS_ON_PROJECT.Exception.InvalidDataException;

import java.io.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManager {
    private static final String DATA_FILE = "students.csv";
    private static final String BACKUP_DIR = "backups/";

    // Save all students to file
    public static void saveStudents(ArrayList<Student> students) throws IOException {
        // Create backup first
        createBackup();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            // Write header
            writer.write("Name,Age,ID,Email,Major,GPA,Courses");
            writer.newLine();

            // Write student data
            for (Student student : students) {
                writer.write(student.toCSV());
                writer.newLine();
            }

            System.out.println("✓ Data saved successfully to " + DATA_FILE);

        } catch (IOException e) {
            System.out.println("✗ Error saving data: " + e.getMessage());
            throw e;
        }
    }

    // Load all students from file
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("No existing data file found. Starting fresh.");
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            boolean firstLine = true;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    Student student = Student.fromCSV(line);
                    students.add(student);
                } catch (InvalidDataException e) {
                    System.out.println("Warning: Skipping invalid data at line " + lineNumber);
                    System.out.println("  Reason: " + e.getMessage());
                }
            }

            System.out.println("✓ Loaded " + students.size() + " students from file");

        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Starting with empty database.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return students;
    }

    // Create backup of current data
    private static void createBackup() {
        File dataFile = new File(DATA_FILE);
        if (!dataFile.exists()) {
            return;  // Nothing to backup
        }

        // Create backup directory if it doesn't exist
        File backupDir = new File(BACKUP_DIR);
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        // Generate backup filename with timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        String backupFilename = BACKUP_DIR + "students_" + timestamp + ".csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(backupFilename))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("✓ Backup created: " + backupFilename);

        } catch (IOException e) {
            System.out.println("Warning: Could not create backup: " + e.getMessage());
        }
    }

    // Export students to CSV (user-friendly format)
    public static void exportToCSV(ArrayList<Student> students, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write header
            writer.write("Student Name,Age,Student ID,Email,Major,GPA,Number of Courses");
            writer.newLine();

            // Write data
            for (Student student : students) {
                writer.write(String.format("%s,%d,%s,%s,%s,%.2f,%d",
                        student.getName(),
                        student.getAge(),
                        student.getId(),
                        student.getEmail(),
                        student.getMajor(),
                        student.getGpa(),
                        student.getEnrolledCourses().size()));
                writer.newLine();
            }

            System.out.println("✓ Data exported to " + filename);

        } catch (IOException e) {
            System.out.println("✗ Export failed: " + e.getMessage());
        }
    }

    // Import students from CSV
    public static ArrayList<Student> importFromCSV(String filename) throws IOException, InvalidDataException {
        ArrayList<Student> importedStudents = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;
            int lineNumber = 1;
            int successCount = 0;
            int errorCount = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    Student student = Student.fromCSV(line);
                    importedStudents.add(student);
                    successCount++;
                } catch (InvalidDataException e) {
                    System.out.println("Line " + lineNumber + " error: " + e.getMessage());
                    errorCount++;
                }
            }

            System.out.println("\n=== Import Summary ===");
            System.out.println("Successfully imported: " + successCount);
            System.out.println("Errors: " + errorCount);

        } catch (FileNotFoundException e) {
            throw new IOException("Import file not found: " + filename);
        }

        return importedStudents;
    }
}