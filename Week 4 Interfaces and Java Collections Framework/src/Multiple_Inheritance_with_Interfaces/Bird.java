package Multiple_Inheritance_with_Interfaces;

// Bird can fly and walk
public class Bird implements Flyable, Walkable {
    private String type;

    public Bird(String type) {
        this.type = type;
    }

    @Override
    public void fly() {
        System.out.println(type + " is soaring through the air!");
    }

    @Override
    public void land() {
        System.out.println(type + " is landing on a branch.");
    }

    @Override
    public void walk() {
        System.out.println(type + " is hopping around.");
    }

    @Override
    public void run() {
        System.out.println(type + " is running fast!");
    }
}