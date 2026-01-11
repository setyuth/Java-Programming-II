package PolymorphismDemonstration;

public class PayrollSystem {
    public static void main(String[] args) {
        // Polymorphism: Parent reference, child objects
        Employee emp1 = new FullTimeEmployee("Alice", "FT001", 50000, 5000);
        Employee emp2 = new PartTimeEmployee("Bob", "PT001", 120, 25);
        Employee emp3 = new Contractor("Charlie", "CT001", 75000);

        // Array of Employee references
        Employee[] employees = {emp1, emp2, emp3};

        System.out.println("=== PAYROLL REPORT ===\n");

        double totalPayroll = 0;
        for (Employee employee : employees) {
            employee.displayInfo();  // Calls appropriate version based on actual object type
            totalPayroll += employee.calculateSalary();
            System.out.println("─".repeat(30));
        }

        System.out.println("\nTotal Payroll: $" + totalPayroll);
    }
}