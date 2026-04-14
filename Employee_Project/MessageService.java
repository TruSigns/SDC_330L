/**
 * Name: Maurice Ruffin
 * Date: 04/13/2026
 * Purpose: Handles message displays for the Employee Management Application.
 */

public class MessageService {

    private MessageService() {
        /*
         * Private constructor prevents instantiation of this utility class.
         */
    }

    public static void displayHeader() {
        System.out.println("Week 3 Project");
        System.out.println("Abstraction, Constructors, and Access Specifiers");
        System.out.println("Maurice Ruffin");
        System.out.println("========================================");
        System.out.println();
    }

    public static void displayWelcome() {
        System.out.println("Welcome to the Employee Management Application.");
        System.out.println("Use the menu below to display employee information and weekly pay.");
        System.out.println("This project demonstrates abstraction, constructors, access specifiers, interfaces, and polymorphism.");
        System.out.println();
    }

    public static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Display all employees");
        System.out.println("2. Display hourly employees");
        System.out.println("3. Display salaried employees");
        System.out.println("4. Display weekly pay");
        System.out.println("5. Exit");
        System.out.println();
    }
}