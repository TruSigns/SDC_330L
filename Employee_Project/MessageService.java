/**
 * Name: Maurice Ruffin
 * Date: 04/15/2026
 * Purpose: Handles message displays for the Employee Management Application.
 */

public class MessageService {

    private MessageService() {
        /*
         * Private constructor prevents this utility class from being instantiated.
         */
    }

    public static void displayHeader() {
        System.out.println("Week 4 Project");
        System.out.println("Database Interactions");
        System.out.println("Maurice Ruffin");
        System.out.println("========================================");
        System.out.println();
    }

    public static void displayWelcome() {
        System.out.println("Welcome to the Employee Management Application.");
        System.out.println("Use the menu to add, view, update, and delete employees stored in a SQLite database.");
        System.out.println("This project continues to demonstrate abstraction, constructors, and access specifiers.");
        System.out.println();
    }

    public static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Add employee");
        System.out.println("2. Display all employees");
        System.out.println("3. Find employee by ID");
        System.out.println("4. Update employee");
        System.out.println("5. Delete employee");
        System.out.println("6. Exit");
        System.out.println();
    }
}