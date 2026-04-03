/**
 * Name: Maurice Ruffin
 * Date: 04/03/2026
 * Purpose: Base class for all employees in the Employee Management Application.
 * This file demonstrates the base class used for inheritance.
 */

public class Employee {
    private int employeeId;
    private String name;
    private String position;

    public Employee(int employeeId, String name, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmployeeType() {
        return "General";
    }

    public String getDetails() {
        return "ID: " + employeeId +
               " | Name: " + name +
               " | Position: " + position;
    }
}