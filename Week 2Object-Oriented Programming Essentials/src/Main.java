public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", 20, "Computer Science", 3.8);

        // Cannot do this anymore (compilation error):
        //student.name = "Bob";     // Error: name has private access

        // Must use getters and setters
        System.out.println("Student Name: " + student.getName());

        // Try to set invalid values
        student.setGpa(5.0);    // Will show error message
        student.setAge(-5);     // Will show error message

        // Set valid values
        student.setGpa(3.9);
        student.setAge(21);

        System.out.println("\n=== Updated Student Info ===");
        student.displayInfo();
    }
}