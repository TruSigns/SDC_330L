/**
 * Name: Maurice Ruffin
 * Date: 04/13/2026
 * Purpose: Week 3 project main application file for the Employee Management Application.
 * This file demonstrates abstraction, constructors, and access specifiers.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MessageService.displayHeader();
        MessageService.displayWelcome();

        /*
         * Composition is demonstrated here because Department contains Employee objects.
         * Constructor use is demonstrated by creating objects with realistic values.
         */
        Department department = new Department("Information Technology");

        /*
         * Abstraction is demonstrated here because Employee is now an abstract class.
         * The application creates HourlyEmployee and SalariedEmployee objects through
         * Employee references.
         */
        Employee emp1 = new HourlyEmployee(101, "Jordan Miles", "Support Specialist", 22.50, 40);
        Employee emp2 = new SalariedEmployee(102, "Alicia Carter", "Project Manager", 72000.00);
        Employee emp3 = new HourlyEmployee(103, "Brian Woods", "Lab Assistant", 18.75, 35);
        Employee emp4 = new SalariedEmployee(104, "Tiana Brooks", "Systems Analyst", 68000.00);

        department.addEmployee(emp1);
        department.addEmployee(emp2);
        department.addEmployee(emp3);
        department.addEmployee(emp4);

        /*
         * Polymorphism is demonstrated here by treating different employee types
         * as Payable objects through the interface.
         */
        ArrayList<Payable> payroll = new ArrayList<>();
        payroll.add((Payable) emp1);
        payroll.add((Payable) emp2);
        payroll.add((Payable) emp3);
        payroll.add((Payable) emp4);

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
                    System.out.println();
                    System.out.println("Weekly Pay");
                    System.out.println("========================================");

                    for (Payable employee : payroll) {
                        System.out.println("Pay: $" + String.format("%.2f", employee.calculatePay()));
                    }

                    System.out.println();
                    break;

                case "5":
                    running = false;
                    System.out.println();
                    System.out.println("Thank you for using the Employee Management Application.");
                    System.out.println("Exiting program now.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please enter 1, 2, 3, 4, or 5.");
            }
        }

        scanner.close();
    }
}