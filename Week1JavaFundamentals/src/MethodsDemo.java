public class MethodsDemo {

    // Method with no parameters, no return
    public static void greet() {
        System.out.println("Hello! Welcome to Java programming.");
    }

    // Method with parameters, no return
    public static void greetPerson(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Method with parameters and return value
    public static int add(int a, int b) {
        return a + b;
    }

    // Method with return value
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Method that calls another method
    public static void displayCalculation(int x, int y) {
        int result = add(x, y);
        System.out.println(x + " + " + y + " = " + result);
    }

    public static void main(String[] args) {
        // Calling methods
        greet();
        greetPerson("Alice");

        int sum = add(5, 3);
        System.out.println("Sum: " + sum);

        double area = calculateArea(5.0);
        System.out.println("Circle area: " + area);

        displayCalculation(10, 20);
    }
}