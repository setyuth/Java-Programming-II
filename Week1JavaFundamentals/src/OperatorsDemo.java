public class OperatorsDemo {
    public static void main(String[] args) {
        // Arithmetic operators
        int a = 10, b = 3;
        System.out.println("Addition:  " + (a + b)); // 13
        System.out.println("Subtraction:  " + (a - b)); // 7
        System.out.println("Multiplication:  " + (a * b)); // 30
        System.out.println("Division:  " + (a / b)); // 3 (integer division)
        System.out.println("Modulus:  " + (a % b));  // 1

        // Comparison operators
        System.out.println("a > b " + (a > b));  // True
        System.out.println("b == a " + (a == b)); // False

        // Logical operators
        boolean x = true, y = false;
        System.out.println("x && y: " + (x && y)); // false
        System.out.println("x || y: " + (x || y)); // true
    }
}
