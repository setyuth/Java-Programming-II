public class Calculator {

    // Add two integers
    public int add(int a, int b) {
        System.out.println("Adding two integers");
        return a + b;
    }

    // Add three integers
    public int add(int a, int b, int c) {
        System.out.println("Adding three integers");
        return a + b + c;
    }

    // Add two doubles
    public double add(double a, double b) {
        System.out.println("Adding two doubles");
        return a + b;
    }

    // Add two strings (concatenation)
    public String add(String a, String b) {
        System.out.println("Concatenating two strings");
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Result: " + calc.add(5, 10));           // Calls int version
        System.out.println("Result: " + calc.add(5, 10, 15));       // Calls three int version
        System.out.println("Result: " + calc.add(5.5, 10.3));       // Calls double version
        System.out.println("Result: " + calc.add("Hello ", "World")); // Calls String version
    }
}