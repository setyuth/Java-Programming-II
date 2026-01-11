package Inheritance;

// Child class (Derived class / Subclass)
public class Dog extends Animal {
    private String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age);  // Call parent constructor
        this.breed = breed;
    }

    // Dog-specific method
    public void bark() {
        System.out.println(name + " says: Woof! Woof!");
    }

    // Override parent method
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent's displayInfo
        System.out.println("Breed: " + breed);
        System.out.println("Type: Dog");
    }
}