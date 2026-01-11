package AbstractClassImplementation;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Car engine starting... Vroom!");
    }

    @Override
    public void stop() {
        System.out.println("Car engine stopping... Engine off.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
        System.out.println("Type: Car");
    }
}