package MethodOverridingRules;

public class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // Method to be overridden
    public double calculateArea() {
        return 0.0;
    }

    public void display() {
        System.out.println("Shape color: " + color);
    }
}