package Hands_On_Project;

import java.util.Scanner;

public class EnhancedCalculator {

    // Method to display menu
    public static void displayMenu() {
        System.out.println("\n========== CALCULATOR ==========");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulus (%)");         // Added
        System.out.println("6. Power (^)");           // Added
        System.out.println("7. Square Root (√)");     // Added
        System.out.println("8. Exit");
        System.out.println("================================");
        System.out.print("Enter your choice (1-8): ");
    }

    // --- Existing Methods ---
    public static double add(double num1, double num2) { return num1 + num2; }
    public static double subtract(double num1, double num2) { return num1 - num2; }
    public static double multiply(double num1, double num2) { return num1 * num2; }
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return Double.NaN; // Return Not-a-Number to indicate error
        }
        return num1 / num2;
    }

    // --- New Methods for Homework ---

    // 1. Modulus Operation
    public static double modulus(double num1, double num2) {
        return num1 % num2;
    }

    // 2. Power Operation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // 3. Square Root Operation
    public static double squareRoot(double num) {
        if (num < 0) {
            System.out.println("Error: Cannot calculate square root of a negative number!");
            return Double.NaN;
        }
        return Math.sqrt(num);
    }

    // Method to get TWO numbers
    public static double[] getTwoNumbers(Scanner scanner) {
        double[] numbers = new double[2];
        System.out.print("Enter first number: ");
        numbers[0] = scanner.nextDouble();
        System.out.print("Enter second number: ");
        numbers[1] = scanner.nextDouble();
        return numbers;
    }

    // Method to get ONE number (for Square Root)
    public static double getOneNumber(Scanner scanner) {
        System.out.print("Enter number: ");
        return scanner.nextDouble();
    }

    public static void performCalculation(int choice, double num1, double num2) {
        double result = 0;
        String operation = "";

        switch (choice) {
            case 1: result = add(num1, num2); operation = "+"; break;
            case 2: result = subtract(num1, num2); operation = "-"; break;
            case 3: result = multiply(num1, num2); operation = "*"; break;
            case 4: result = divide(num1, num2); operation = "/"; break;
            case 5: result = modulus(num1, num2); operation = "%"; break;
            case 6: result = power(num1, num2); operation = "^"; break;
            case 7:
                result = squareRoot(num1);
                System.out.println("\nResult: √" + num1 + " = " + result);
                return; // Return early for square root to avoid the standard print below
            default: System.out.println("Invalid choice!"); return;
        }

        // Only print if the result is valid (not NaN)
        if (!Double.isNaN(result)) {
            System.out.println("\nResult: " + num1 + " " + operation + " " + num2 + " = " + result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Enhanced Calculator!");

        do {
            displayMenu();
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 6) {
                // Operations requiring two numbers
                double[] numbers = getTwoNumbers(scanner);
                performCalculation(choice, numbers[0], numbers[1]);
            } else if (choice == 7) {
                // Operation requiring one number
                double number = getOneNumber(scanner);
                performCalculation(choice, number, 0); // Pass 0 as dummy second number
            } else if (choice == 8) {
                System.out.println("\nThank you for using the calculator!");
                System.out.println("Goodbye!");
            } else {
                System.out.println("\nInvalid choice! Please enter 1-8.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
