package AbstractClassImplementation;

public class Main {
    public static void main(String[] args) {
        // Cannot do this: Vehicle v = new Vehicle(...); // Error!

        // Can use polymorphism with abstract class
        Vehicle car = new Car("Toyota", "Camry", 2023, 4);
        Vehicle motorcycle = new Motorcycle("Harley Davidson", "Street 750", 2022, false);

        System.out.println("=== Car ===");
        car.displayInfo();
        car.start();
        car.honk();
        car.stop();

        System.out.println("\n=== Motorcycle ===");
        motorcycle.displayInfo();
        motorcycle.start();
        motorcycle.honk();
        motorcycle.stop();
    }
}