package Homework_Assignment;

public class Admin extends Person {
    private String position;
    private String department;
    private String[] permissions;

    public Admin(String name, int age, String id, String email,
                 String position, String department, String[] permissions) {
        super(name, age, id, email);
        this.position = position;
        this.department = department;
        this.permissions = permissions;
    }

    @Override
    public void displayInfo() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          ADMIN INFORMATION           ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Admin ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
        System.out.print("Permissions: ");
        for (int i = 0; i < permissions.length; i++) {
            System.out.print(permissions[i]);
            if (i < permissions.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    public String getPosition() {
        return position;
    }

    public boolean hasPermission(String permission) {
        for (String perm : permissions) {
            if (perm.equalsIgnoreCase(permission)) {
                return true;
            }
        }
        return false;
    }

    public void listPermissions() {
        System.out.println("Permissions for " + name + ":");
        for (String permission : permissions) {
            System.out.println("  - " + permission);
        }
    }
}
