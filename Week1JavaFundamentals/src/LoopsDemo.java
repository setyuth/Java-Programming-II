import java.util.Scanner;

public class LoopsDemo {
    public static void main(String[] args) {
        // For loop - count to 10
        System.out.println("Counting with for loop:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // While loop - sum of numbers
        System.out.println("\nSum of first 5 numbers:");
        int sum = 0;
        int n = 1;
        while (n <= 5) {
            sum += n;
            n++;
        }
        System.out.println("Sum: " + sum);

        // Do-while loop - menu example
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if (choice != 0) {
                System.out.println("You selected: " + choice);
            }
        } while (choice != 0);

        System.out.println("Goodbye!");
        scanner.close();
    }
}