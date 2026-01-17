package Java_Collections_Framework_Introduction.HashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicatesDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(7);
        numbers.add(3);  // duplicate
        numbers.add(9);
        numbers.add(5);  // duplicate

        System.out.println("Original list: " + numbers);
        System.out.println("Size: " + numbers.size());

        // Remove duplicates using HashSet
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        System.out.println("Unique numbers: " + uniqueNumbers);
        System.out.println("Size: " + uniqueNumbers.size());

        // Convert back to ArrayList if needed
        ArrayList<Integer> cleanList = new ArrayList<>(uniqueNumbers);
        System.out.println("Clean list: " + cleanList);
    }
}
