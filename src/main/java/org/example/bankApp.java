package org.example;

import java.util.Scanner;

public class bankApp {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    public bankApp(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    //    function for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //    function for withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = amount;
        }
    }

    //    function for showing previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //    function for calculating interest for a number of years
    void calculateInterest(int years) {
        double interestRate = 1.11;
        double newBalance = (balance + interestRate + years) + balance;
        System.out.println("The current interest rate is " + (100 + interestRate));
        System.out.println("The new balance will be " + newBalance + "after " + years + "years.");
    }

    //    function showing menu
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
//                Case "A" allows the user to check account balance
                case 'A':
                    System.out.println(".........................");
                    System.out.println("Balance = #" + balance);
                    System.out.println("..........................");
                    System.out.println();
                    break;
//                    case "B" allows the user to make a deposit
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
//                    case "C" enables the user to make a withdrawal to from his or her account
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
//                case "D" allows the user to view previous transaction
                case 'D' :
                    System.out.println("...........................");
                    getPreviousTransaction();
                    System.out.println("............................");
                    System.out.println();
                    break;
//                case "E" will allow the user to calculate interest on amount for an amount of years.
                case 'E':
                    System.out.println("Enter number of years to calculate interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
//                    case "F" exits the user from the bank app
                case 'F' :
                    System.out.println("............................");
                    break;
//                    The default case lets the user know they have entered an invalid letter.
                default:
                    System.out.println("Invalid! Kindly enter options A - F");
                    break;
            }
        }while(option != 'F');
        System.out.println("Thank you for banking with us");
    }
}
