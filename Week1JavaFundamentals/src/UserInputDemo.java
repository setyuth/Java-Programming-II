import java.util.Scanner;

public class UserInputDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get string input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Get integer input
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Get double input
        System.out.print("Enter your height (in meters): ");
        double height = scanner.nextDouble();

        // Display results
        System.out.println("\n--- Your Information ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + "m");

        scanner.close();
    }
}