package MethodOverridingRules;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Rectangle dimensions: " + length + " x " + width);
        System.out.println("Rectangle area: " + calculateArea());
    }
}