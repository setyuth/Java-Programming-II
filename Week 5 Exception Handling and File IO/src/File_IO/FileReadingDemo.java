package File_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingDemo {
    public static void main(String[] args) {
        // Method 1: Using Scanner
        try {
            File file = new File("data.txt");
            Scanner fileScanner = new Scanner(file);

            System.out.println("=== Reading File ===");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            System.out.println("Please create 'data.txt' in the project directory.");
        }
    }
}
