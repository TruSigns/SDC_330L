/**
 * Name: Maurice Ruffin
 * Date: 04/13/2026
 * Purpose: Derived class for salaried employees.
 * This file demonstrates inheritance, abstraction, constructors, and interface implementation.
 */

public class SalariedEmployee extends Employee implements Payable {
    private double annualSalary;

    public SalariedEmployee(int employeeId, String name, String position, double annualSalary) {
        super(employeeId, name, position);
        this.annualSalary = annualSalary;
    }

    public SalariedEmployee(String name, String position, double annualSalary) {
        super(name, position);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public String getEmployeeType() {
        return "Salaried";
    }

    @Override
    public double calculatePay() {
        return annualSalary / 52;
    }

    @Override
    public String getDetails() {
        return getBaseDetails() +
               " | Type: Salaried" +
               " | Annual Salary: $" + String.format("%.2f", annualSalary) +
               " | Weekly Pay: $" + String.format("%.2f", calculatePay());
    }
}