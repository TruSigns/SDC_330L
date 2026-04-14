/**
 * Name: Maurice Ruffin
 * Date: 04/13/2026
 * Purpose: Abstract base class for all employees in the Employee Management Application.
 * This file demonstrates abstraction through the use of an abstract class and abstract method.
 */

public abstract class Employee {
    /*
     * Access specifiers are used appropriately here.
     * Fields are private so they cannot be modified directly outside this class.
     */
    private int employeeId;
    private String name;
    private String position;

    /*
     * Constructor with parameters.
     */
    public Employee(int employeeId, String name, String position) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    /*
     * Overloaded constructor.
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
     * Protected helper method can be used by derived classes,
     * but is not exposed publicly to unrelated classes.
     */
    protected String getBaseDetails() {
        return "ID: " + employeeId +
               " | Name: " + name +
               " | Position: " + position;
    }

    /*
     * Abstraction is demonstrated here.
     * Every child class must define its own employee type and details.
     */
    public abstract String getEmployeeType();
    public abstract String getDetails();
}