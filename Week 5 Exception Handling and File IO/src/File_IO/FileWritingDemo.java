package File_IO;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWritingDemo {
    public static void main(String[] args) {
        // Method 1: Simple FileWriter
//        try {
//            FileWriter writer = new FileWriter("output.txt");
//            writer.write("Hello, File I/O!\n");
//            writer.write("This is line 2.\n");
//            writer.write("This is line 3.\n");
//            writer.close();
//            System.out.println("File written successfully!");
//
//        } catch (IOException e) {
//            System.out.println("Error writing file: " + e.getMessage());
//        }

        // Method 2: BufferedWriter (more efficient)
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));

            bw.write("Alice,20,Computer Science,3.8");
            bw.newLine();
            bw.write("Bob,22,Mathematics,3.5");
            bw.newLine();
            bw.write("Charlie,21,Physics,3.9");
            bw.newLine();

            bw.close();
            System.out.println("Student data written successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
