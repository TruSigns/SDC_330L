/**
 * Name: Maurice Ruffin
 * Date: 04/09/2026
 * Purpose: Week 2 project main application file demonstrating interfaces and polymorphism.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Week 2 Project");
        System.out.println("Interfaces and Polymorphism");
        System.out.println("Maurice Ruffin");
        System.out.println("========================================\n");

        MessageService.displayWelcome();

        /*
         * Composition is demonstrated here because Department contains Employee objects.
         */
        Department department = new Department("Information Technology");

        /*
         * Inheritance is demonstrated here because HourlyEmployee and SalariedEmployee
         * extend the Employee base class.
         * Interface is demonstrated because both implement Payable.
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
         * Polymorphism using interface
         * Different objects treated as Payable
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
                    System.out.println("Weekly Pay (Polymorphism Demo)");
                    System.out.println("========================================");

                    for (Payable p : payroll) {
                        System.out.println("Pay: $" + String.format("%.2f", p.calculatePay()));
                    }
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