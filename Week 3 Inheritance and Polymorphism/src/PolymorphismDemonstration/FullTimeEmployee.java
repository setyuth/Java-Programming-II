package PolymorphismDemonstration;

public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String name, String id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}