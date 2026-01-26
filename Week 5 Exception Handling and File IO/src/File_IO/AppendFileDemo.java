package File_IO;

import java.io.FileWriter;
import java.io.IOException;

public class AppendFileDemo {
    public static void main(String[] args) {
        try {
            // true parameter means append mode
            FileWriter writer = new FileWriter("log.txt", true);

            writer.write("New log entry at " + new java.util.Date() + "\n");
            writer.write("User logged in\n");
            writer.write("---\n");

            writer.close();
            System.out.println("Log appended successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
