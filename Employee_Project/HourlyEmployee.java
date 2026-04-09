/**
 * Name: Maurice Ruffin
 * Date: 04/09/2026
 * Purpose: Derived class for hourly employees.
 * Demonstrates inheritance, interface implementation, and polymorphism.
 */

public class HourlyEmployee extends Employee implements Payable {
    private double hourlyRate;
    private int hoursPerWeek;

    public HourlyEmployee(int employeeId, String name, String position, double hourlyRate, int hoursPerWeek) {
        super(employeeId, name, position);
        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = hoursPerWeek;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    @Override
    public String getEmployeeType() {
        return "Hourly";
    }

    /*
     * Interface implementation
     * Polymorphism: Different calculation compared to salaried employees
     */
    @Override
    public double calculatePay() {
        return hourlyRate * hoursPerWeek;
    }

    @Override
    public String getDetails() {
        return super.getDetails() +
               " | Type: Hourly" +
               " | Weekly Pay: $" + String.format("%.2f", calculatePay());
    }
}