package Introduction_to_Interfaces;

public class Photo implements Printable {
    private String filename;
    private int width;
    private int height;

    public Photo(String filename, int width, int height) {
        this.filename = filename;
        this.width = width;
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println("=== Printing Photo ===");
        System.out.println("Filename: " + filename);
        System.out.println("Dimensions: " + width + "x" + height);
        System.out.println("Format: " + DEFAULT_FORMAT);
    }
}