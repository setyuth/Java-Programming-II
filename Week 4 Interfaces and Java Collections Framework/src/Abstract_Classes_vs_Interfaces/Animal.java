package Abstract_Classes_vs_Interfaces;

// Abstract class for common animal properties
public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    // Abstract method
    public abstract void makeSound();
}
