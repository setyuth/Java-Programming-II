package MethodOverridingRules;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5.0);
        circle.display();

        System.out.println("\n" + "=".repeat(30) + "\n");

        Rectangle rectangle = new Rectangle("Blue", 4.0, 6.0);
        rectangle.display();
    }
}