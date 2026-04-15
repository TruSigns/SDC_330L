/**
 * Name: Maurice Ruffin
 * Date: 04/15/2026
 * Purpose: Abstract base class for all employees in the Employee Management Application.
 * This file demonstrates abstraction through the use of an abstract class and abstract methods.
 */

public abstract class Employee {
    /*
     * Access specifiers are used appropriately.
     * These fields are private to protect employee data from direct outside access.
     */
    private int employeeId;
    private String name;
    private String position;

    /*
     * Constructor with full employee information.
     */
    public Employee(int employeeId, String name, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    /*
     * Overloaded constructor demonstrating constructor use.
     */
    public Employee(String name, String position) {
        this.employeeId = 0;
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

    /*
     * Protected helper method for derived classes.
     * It is available to child classes but not exposed broadly.
     */
    protected String getBaseDetails() {
        return "ID: " + employeeId +
               " | Name: " + name +
               " | Position: " + position;
    }

    /*
     * Abstraction is demonstrated here.
     * Each employee type must define these methods.
     */
    public abstract String getEmployeeType();
    public abstract String getDetails();
}