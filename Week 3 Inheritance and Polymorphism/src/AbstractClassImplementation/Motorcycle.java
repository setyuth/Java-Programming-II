package AbstractClassImplementation;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle engine starting... Vroom vroom!");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle engine stopping... Quiet now.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Type: Motorcycle");
    }
}