package Common_Runtime_Exceptions;

public class CommonExceptionsDemo {
    public static void main(String[] args) {
        // 1. ArithmeticException
        try {
            int result = 10 / 0;  // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }

        // 2. NullPointerException
        try {
            String text = null;
            System.out.println(text.length());  // Calling method on null
        } catch (NullPointerException e) {
            System.out.println("Error: String is null!");
        }

        // 3. ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // Index doesn't exist
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }

        // 4. NumberFormatException
        try {
            int num = Integer.parseInt("abc");  // Not a valid number
        } catch (NumberFormatException e) {
            System.out.println("Error: Cannot convert to number!");
        }

        System.out.println("Program continues running!");
    }
}