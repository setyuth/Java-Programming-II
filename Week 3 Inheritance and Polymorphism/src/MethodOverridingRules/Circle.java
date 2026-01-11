package MethodOverridingRules;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Override parent method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        super.display();  // Call parent's display
        System.out.println("Circle radius: " + radius);
        System.out.println("Circle area: " + calculateArea());
    }
}