package Abstract_Classes_vs_Interfaces;

// Penguin: IS-A Animal, CAN-DO Swimmable (but cannot fly!)
public class Penguin extends Animal implements Swimmable {

    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Honk honk!");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming underwater!");
    }
}