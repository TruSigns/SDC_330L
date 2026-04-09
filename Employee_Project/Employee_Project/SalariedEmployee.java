/**
 * Name: Maurice Ruffin
 * Date: 04/09/2026
 * Purpose: Derived class for salaried employees.
 * Demonstrates inheritance, interface implementation, and polymorphism.
 */

public class SalariedEmployee extends Employee implements Payable {
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

    
    /*
     * Interface implementation
     * Polymorphism: Different behavior for calculating pay
     */
    @Override
    public double calculatePay() {
        return annualSalary / 52;
    }

    @Override
    public String getDetails() {
        return super.getDetails() +
               " | Type: Salaried" +
               " | Weekly Pay: $" + String.format("%.2f", calculatePay());
    }
}