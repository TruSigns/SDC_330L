/**
 * Name: Maurice Ruffin
 * Date: 04/03/2026
 * Purpose: Handles message displays for the Employee Management Application.
 * This file provides reusable output methods for the main application.
 */

public class MessageService {
    public static void displayHeader() {
        System.out.println("Week 1 Project");
        System.out.println("Inheritance, Composition, and User Interactions");
        System.out.println("Maurice Ruffin");
        System.out.println("========================================");
        System.out.println();
    }

    public static void displayWelcome() {
        System.out.println("Welcome to the Employee Management Application.");
        System.out.println("This program demonstrates basic user interaction, inheritance, and composition.");
        System.out.println("Choose a menu option to view employee information.");
        System.out.println();
    }

    public static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Display all employees");
        System.out.println("2. Display hourly employees");
        System.out.println("3. Display salaried employees");
        System.out.println("4. Exit");
        System.out.println();
    }
}