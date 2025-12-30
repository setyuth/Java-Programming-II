package Hands_On_Project;

import java.util.Scanner;

public class SimpleCalculator {

    // Method to display menu
    public static void displayMenu() {
        System.out.println("\n========== CALCULATOR ==========");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
        System.out.println("================================");
        System.out.print("Enter your choice (1-5): ");
    }

    // Method for addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method for subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method for multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method for division
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return num1 / num2;
    }

    // Method to get numbers from user
    public static double[] getNumbers(Scanner scanner) {
        double[] numbers = new double[2];

        System.out.print("Enter first number: ");
        numbers[0] = scanner.nextDouble();

        System.out.print("Enter second number: ");
        numbers[1] = scanner.nextDouble();

        return numbers;
    }

    // Method to perform calculation based on choice
    public static void performCalculation(int choice, double num1, double num2) {
        double result = 0;
        String operation = "";

        switch (choice) {
            case 1:
                result = add(num1, num2);
                operation = "+";
                break;
            case 2:
                result = subtract(num1, num2);
                operation = "-";
                break;
            case 3:
                result = multiply(num1, num2);
                operation = "*";
                break;
            case 4:
                result = divide(num1, num2);
                operation = "/";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\nResult: " + num1 + " " + operation + " " + num2 + " = " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Simple Calculator!");

        do {
            displayMenu();
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                double[] numbers = getNumbers(scanner);
                performCalculation(choice, numbers[0], numbers[1]);
            } else if (choice == 5) {
                System.out.println("\nThank you for using the calculator!");
                System.out.println("Goodbye!");
            } else {
                System.out.println("\nInvalid choice! Please enter 1-5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}