package Java_Collections_Framework_Introduction.HashSet;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        // Creating HashSet
        HashSet<String> cities = new HashSet<>();

        // Adding elements
        cities.add("New York");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("Paris");
        cities.add("London");  // Duplicate - won't be added!

        System.out.println("Cities: " + cities);
        System.out.println("Size: " + cities.size());  // Still 4, not 5

        // Check if element exists
        if (cities.contains("Tokyo")) {
            System.out.println("Tokyo is in the set!");
        }

        // Remove element
        cities.remove("Paris");
        System.out.println("After removal: " + cities);

        // Iterate through HashSet
        System.out.println("\n=== All Cities ===");
        for (String city : cities) {
            System.out.println("- " + city);
        }

        // NOTE: Order is not guaranteed in HashSet!
    }
}