package Multiple_Inheritance_with_Interfaces;

// Fish can only swim
public class Fish implements Swimmable {
    private String species;

    public Fish(String species) {
        this.species = species;
    }

    @Override
    public void swim() {
        System.out.println(species + " is swimming gracefully.");
    }

    @Override
    public void dive() {
        System.out.println(species + " is diving deep!");
    }
}
