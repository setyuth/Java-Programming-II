package Java_Collections_Framework_Introduction;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Creating ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());

        // Accessing elements
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Last fruit: " + fruits.get(fruits.size() - 1));

        // Adding at specific position
        fruits.add(1, "Grapes");
        System.out.println("After insertion: " + fruits);

        // Checking if element exists
        if (fruits.contains("Banana")) {
            System.out.println("We have bananas!");
        }

        // Removing elements
        fruits.remove("Orange");  // Remove by value
        fruits.remove(0);         // Remove by index
        System.out.println("After removal: " + fruits);

        // Iterating through ArrayList
        System.out.println("\n=== All Fruits ===");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        // Clear all elements
        fruits.clear();
        System.out.println("After clear, size: " + fruits.size());
        System.out.println("Is empty? " + fruits.isEmpty());
    }
}
