package Introduction_to_Interfaces;

// Implementing the interface
public class Document implements Printable {
    private String title;
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println("=== Printing Document ===");
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Format: " + DEFAULT_FORMAT);
    }
}
