/**
 * Name: Maurice Ruffin
 * Date: 04/13/2026
 * Purpose: Stores and manages a collection of Employee objects.
 * This file demonstrates composition because a Department has Employee objects.
 */

import java.util.ArrayList;

public class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    /*
     * Constructor with department name.
     */
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    /*
     * Overloaded constructor.
     */
    public Department() {
        this.departmentName = "General Department";
        this.employees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayAllEmployees() {
        System.out.println("Department: " + departmentName);
        System.out.println();

        for (Employee employee : employees) {
            System.out.println(employee.getDetails());
        }

        System.out.println();
    }

    public void displayEmployeesByType(String type) {
        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getEmployeeType().equalsIgnoreCase(type)) {
                System.out.println(employee.getDetails());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found for type: " + type);
        }

        System.out.println();
    }
}