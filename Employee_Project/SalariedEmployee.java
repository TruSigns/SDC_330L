/**
 * Name: Maurice Ruffin
 * Date: 04/03/2026
 * Purpose: Derived class for salaried employees.
 * This file demonstrates inheritance by extending the Employee base class.
 */

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(int employeeId, String name, String position, double annualSalary) {
        super(employeeId, name, position);
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
    public String getDetails() {
        return super.getDetails() +
               " | Type: Salaried" +
               " | Annual Salary: $" + String.format("%.2f", annualSalary);
    }
}