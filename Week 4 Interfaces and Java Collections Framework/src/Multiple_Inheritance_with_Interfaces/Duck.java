package Multiple_Inheritance_with_Interfaces;

// Duck can do all three!
public class Duck implements Flyable, Swimmable, Walkable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying in the sky!");
    }

    @Override
    public void land() {
        System.out.println(name + " is landing on the ground.");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming in the water.");
    }

    @Override
    public void dive() {
        System.out.println(name + " is diving underwater!");
    }

    @Override
    public void walk() {
        System.out.println(name + " is walking on land.");
    }

    @Override
    public void run() {
        System.out.println(name + " is running quickly!");
    }
}