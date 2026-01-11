package AbstractClassImplementation;

// Abstract class
public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Abstract method (no implementation) - must be overridden
    public abstract void start();

    // Abstract method
    public abstract void stop();

    // Concrete method (with implementation) - can be inherited as-is
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    // Concrete method
    public void honk() {
        System.out.println("Beep beep!");
    }
}