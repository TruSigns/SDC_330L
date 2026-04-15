/**
 * Name: Maurice Ruffin
 * Date: 04/15/2026
 * Purpose: Derived class for hourly employees.
 * This file demonstrates inheritance, abstraction, constructors, and interface implementation.
 */

public class HourlyEmployee extends Employee implements Payable {
    private double hourlyRate;
    private int hoursPerWeek;

    public HourlyEmployee(int employeeId, String name, String position, double hourlyRate, int hoursPerWeek) {
        super(employeeId, name, position);
        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = hoursPerWeek;
    }

    public HourlyEmployee(String name, String position, double hourlyRate) {
        super(name, position);
        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = 40;
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

    @Override
    public double calculatePay() {
        return hourlyRate * hoursPerWeek;
    }

    @Override
    public String getDetails() {
        return getBaseDetails() +
               " | Type: Hourly" +
               " | Hourly Rate: $" + String.format("%.2f", hourlyRate) +
               " | Hours Per Week: " + hoursPerWeek +
               " | Weekly Pay: $" + String.format("%.2f", calculatePay());
    }
}