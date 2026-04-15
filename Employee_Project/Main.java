/**
 * Name: Maurice Ruffin
 * Date: 04/15/2026
 * Purpose: Week 4 project main application file for the Employee Management Application.
 * This file demonstrates database interactions with SQLite and full CRUD operations.
 */

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MessageService.displayHeader();
        MessageService.displayWelcome();

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.initializeDatabase();

        EmployeeDAO employeeDAO = new EmployeeDAO();

        /*
         * Realistic starter data for the database.
         * The DAO checks if the table is empty before inserting sample records.
         */
        employeeDAO.insertSampleData();

        boolean running = true;

        while (running) {
            MessageService.displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addEmployee(scanner, employeeDAO);
                    break;

                case "2":
                    displayAllEmployees(employeeDAO);
                    break;

                case "3":
                    displayEmployeeById(scanner, employeeDAO);
                    break;

                case "4":
                    updateEmployee(scanner, employeeDAO);
                    break;

                case "5":
                    deleteEmployee(scanner, employeeDAO);
                    break;

                case "6":
                    running = false;
                    System.out.println();
                    System.out.println("Thank you for using the Employee Management Application.");
                    System.out.println("Exiting program now.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please enter 1, 2, 3, 4, 5, or 6.");
            }
        }

        scanner.close();
    }

    private static void addEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println();
        System.out.println("Add Employee");
        System.out.println("========================================");

        System.out.print("Enter employee type (Hourly or Salaried): ");
        String type = scanner.nextLine().trim();

        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter employee position: ");
        String position = scanner.nextLine().trim();

        Employee employee;

        if (type.equalsIgnoreCase("Hourly")) {
            System.out.print("Enter hourly rate: ");
            double hourlyRate = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter hours per week: ");
            int hoursPerWeek = Integer.parseInt(scanner.nextLine().trim());

            employee = new HourlyEmployee(id, name, position, hourlyRate, hoursPerWeek);
        } else if (type.equalsIgnoreCase("Salaried")) {
            System.out.print("Enter annual salary: ");
            double annualSalary = Double.parseDouble(scanner.nextLine().trim());

            employee = new SalariedEmployee(id, name, position, annualSalary);
        } else {
            System.out.println("Invalid employee type.");
            return;
        }

        employeeDAO.addEmployee(employee);
        System.out.println("Employee added successfully.");
        System.out.println();
    }

    private static void displayAllEmployees(EmployeeDAO employeeDAO) {
        System.out.println();
        System.out.println("All Employees");
        System.out.println("========================================");

        List<Employee> employees = employeeDAO.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee.getDetails());
            }
        }

        System.out.println();
    }

    private static void displayEmployeeById(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println();
        System.out.println("Find Employee");
        System.out.println("========================================");

        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Employee employee = employeeDAO.getEmployeeById(id);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println(employee.getDetails());
        }

        System.out.println();
    }

    private static void updateEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println();
        System.out.println("Update Employee");
        System.out.println("========================================");

        System.out.print("Enter employee ID to update: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Employee existingEmployee = employeeDAO.getEmployeeById(id);

        if (existingEmployee == null) {
            System.out.println("Employee not found.");
            System.out.println();
            return;
        }

        System.out.print("Enter new employee name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter new employee position: ");
        String position = scanner.nextLine().trim();

        System.out.print("Enter employee type (Hourly or Salaried): ");
        String type = scanner.nextLine().trim();

        Employee updatedEmployee;

        if (type.equalsIgnoreCase("Hourly")) {
            System.out.print("Enter new hourly rate: ");
            double hourlyRate = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter new hours per week: ");
            int hoursPerWeek = Integer.parseInt(scanner.nextLine().trim());

            updatedEmployee = new HourlyEmployee(id, name, position, hourlyRate, hoursPerWeek);
        } else if (type.equalsIgnoreCase("Salaried")) {
            System.out.print("Enter new annual salary: ");
            double annualSalary = Double.parseDouble(scanner.nextLine().trim());

            updatedEmployee = new SalariedEmployee(id, name, position, annualSalary);
        } else {
            System.out.println("Invalid employee type.");
            System.out.println();
            return;
        }

        employeeDAO.updateEmployee(updatedEmployee);
        System.out.println("Employee updated successfully.");
        System.out.println();
    }

    private static void deleteEmployee(Scanner scanner, EmployeeDAO employeeDAO) {
        System.out.println();
        System.out.println("Delete Employee");
        System.out.println("========================================");

        System.out.print("Enter employee ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        employeeDAO.deleteEmployee(id);
        System.out.println("Employee deleted if the record existed.");
        System.out.println();
    }
}