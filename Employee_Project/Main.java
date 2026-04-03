/**
 * Name: Maurice Ruffin
 * Date: 04/03/2026
 * Purpose: Week 1 project main application file for the Employee Management Application.
 * This file displays the title, welcome message, basic menu, and user interaction flow.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MessageService.displayHeader();
        MessageService.displayWelcome();

        /*
         * Composition is demonstrated here because Department contains Employee objects.
         */
        Department department = new Department("Information Technology");

        /*
         * Inheritance is demonstrated here because HourlyEmployee and SalariedEmployee
         * both extend the Employee base class.
         */
        Employee emp1 = new HourlyEmployee(101, "Jordan Miles", "Support Specialist", 22.50, 40);
        Employee emp2 = new SalariedEmployee(102, "Alicia Carter", "Project Manager", 72000.00);
        Employee emp3 = new HourlyEmployee(103, "Brian Woods", "Lab Assistant", 18.75, 35);
        Employee emp4 = new SalariedEmployee(104, "Tiana Brooks", "Systems Analyst", 68000.00);

        department.addEmployee(emp1);
        department.addEmployee(emp2);
        department.addEmployee(emp3);
        department.addEmployee(emp4);

        boolean running = true;

        while (running) {
            MessageService.displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println();
                    System.out.println("All Employees");
                    System.out.println("========================================");
                    department.displayAllEmployees();
                    break;

                case "2":
                    System.out.println();
                    System.out.println("Hourly Employees");
                    System.out.println("========================================");
                    department.displayEmployeesByType("Hourly");
                    break;

                case "3":
                    System.out.println();
                    System.out.println("Salaried Employees");
                    System.out.println("========================================");
                    department.displayEmployeesByType("Salaried");
                    break;

                case "4":
                    running = false;
                    System.out.println();
                    System.out.println("Thank you for using the Employee Management Application.");
                    System.out.println("Exiting program now.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }
}