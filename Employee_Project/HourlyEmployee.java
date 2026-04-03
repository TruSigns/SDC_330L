/**
 * Name: Maurice Ruffin
 * Date: 04/03/2026
 * Purpose: Derived class for hourly employees.
 * This file demonstrates inheritance by extending the Employee base class.
 */

public class HourlyEmployee extends Employee {
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

    @Override
    public String getDetails() {
        return super.getDetails() +
               " | Type: Hourly" +
               " | Hourly Rate: $" + String.format("%.2f", hourlyRate) +
               " | Hours Per Week: " + hoursPerWeek;
    }
}