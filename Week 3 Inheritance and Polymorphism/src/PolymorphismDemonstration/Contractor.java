package PolymorphismDemonstration;

public class Contractor extends Employee {
    private double projectFee;

    public Contractor(String name, String id, double projectFee) {
        super(name, id, 0);
        this.projectFee = projectFee;
    }

    @Override
    public double calculateSalary() {
        return projectFee;
    }
}