package HANDS_ON_PROJECT;

public abstract class Person {
    protected String name;
    protected int age;
    protected String id;
    protected String email;

    public Person(String name, int age, String id, String email) {
        this.name = name;
        setAge(age);
        this.id = id;
        this.email = email;
    }

    // Abstract method - each person type displays info differently
    public abstract void displayInfo();

    // Abstract method - each person type has different role
    public abstract String getRole();

    // Concrete methods shared by all
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
            this.age = 0;
        }
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
