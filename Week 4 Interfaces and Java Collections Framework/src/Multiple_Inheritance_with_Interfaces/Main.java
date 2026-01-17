package Multiple_Inheritance_with_Interfaces;

public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck("Donald");
        System.out.println("=== Duck ===");
        duck.swim();
        duck.fly();
        duck.walk();

        System.out.println("\n=== Fish ===");
        Fish fish = new Fish("Goldfish");
        fish.swim();
        fish.dive();

        System.out.println("\n=== Bird ===");
        Bird bird = new Bird("Eagle");
        bird.fly();
        bird.land();
        bird.walk();
    }
}