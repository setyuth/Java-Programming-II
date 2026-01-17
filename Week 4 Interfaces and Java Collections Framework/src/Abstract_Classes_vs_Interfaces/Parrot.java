package Abstract_Classes_vs_Interfaces;

// Parrot: IS-A Animal, CAN-DO Flyable
public class Parrot extends Animal implements Flyable {

    public Parrot(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Squawk!");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying with colorful wings!");
    }
}
