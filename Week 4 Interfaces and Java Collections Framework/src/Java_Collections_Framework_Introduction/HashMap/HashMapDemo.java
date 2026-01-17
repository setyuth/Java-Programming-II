package Java_Collections_Framework_Introduction.HashMap;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        // Creating HashMap (Key -> Value)
        HashMap<String, Integer> ages = new HashMap<>();

        // Adding key-value pairs
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 28);
        ages.put("Diana", 22);

        System.out.println("Ages: " + ages);

        // Getting value by key
        System.out.println("Alice's age: " + ages.get("Alice"));

        // Check if key exists
        if (ages.containsKey("Bob")) {
            System.out.println("Bob is in the map!");
        }

        // Check if value exists
        if (ages.containsValue(28)) {
            System.out.println("Someone is 28 years old!");
        }

        // Update value
        ages.put("Alice", 26);  // Updates existing key
        System.out.println("Updated age: " + ages.get("Alice"));

        // Remove entry
        ages.remove("Charlie");
        System.out.println("After removal: " + ages);

        // Iterate through HashMap
        System.out.println("\n=== All Entries ===");
        for (String name : ages.keySet()) {
            System.out.println(name + " is " + ages.get(name) + " years old");
        }

        // Alternative iteration
        System.out.println("\n=== Using entrySet ===");
        for (var entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}