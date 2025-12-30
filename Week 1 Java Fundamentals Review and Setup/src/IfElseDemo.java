import java.util.Scanner;

public class IfElseDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your exam score (0-100): ");
        int score = scanner.nextInt();

        if (score >= 90) {
            System.out.println("Grade: A - Excellent!");
        } else if (score >= 80) {
            System.out.println("Grade: B - Good job!");
        } else if (score >= 70) {
            System.out.println("Grade: C - Satisfactory");
        } else if (score >= 60) {
            System.out.println("Grade: D - Needs improvement");
        } else {
            System.out.println("Grade: F - Failed");
        }

        scanner.close();
    }
}