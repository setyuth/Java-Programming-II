package HANDS_ON_PROJECT;

public abstract class Person implements Searchable, Displayable {
    protected String name;
    protected int age;
    protected String id;
    protected String email;

    public Person(String name, int age, String id, String email) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.email = email;
    }

    // Implementing Searchable interface
    @Override
    public boolean matches(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return name.toLowerCase().contains(lowerKeyword) ||
                id.toLowerCase().contains(lowerKeyword) ||
                email.toLowerCase().contains(lowerKeyword);
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getId() { return id; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
}