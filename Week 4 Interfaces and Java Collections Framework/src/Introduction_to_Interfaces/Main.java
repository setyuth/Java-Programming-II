package Introduction_to_Interfaces;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Polymorphism with interfaces
        Printable doc = new Document("Java Guide", "This is a comprehensive guide...");
        Printable photo = new Photo("sunset.jpg", 1920, 1080);

        // Array of Printable items
        Printable[] items = {doc, photo};

        for (Printable item : items) {
            item.print();
            System.out.println();
        }
    }
}