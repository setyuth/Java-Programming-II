package Inheritance;

public class Main {
    public static void main(String[] args) {
        // Create a Dog object
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.displayInfo();
        dog.eat();      // Inherited from Animal
        dog.sleep();    // Inherited from Animal
        dog.bark();     // Dog-specific method

        System.out.println("\n" + "=".repeat(30) + "\n");

        // Create a Cat object
        Cat cat = new Cat("Whiskers", 2, "Orange");
        cat.displayInfo();
        cat.eat();      // Inherited from Animal
        cat.sleep();    // Inherited from Animal
        cat.meow();     // Cat-specific method
    }
}