package banking.main;

import banking.accounts.*;
import banking.accounts.exceptions.AccountException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to our bank. Please provide the following details to create an account:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Initial Balance: ");
            double initialBalance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Account Type (Personal, Savings, Business): ");
            String accountType = scanner.nextLine();

            AbstractAccount account = null;
            switch (accountType.toLowerCase()) {
                case "personal":
                    account = new PersonalAccount(initialBalance);
                    break;
                case "savings":
                    account = new SavingsAccount(initialBalance);
                    break;
                case "business":
                    account = new BusinessAccount(initialBalance);
                    break;
                default:
                    System.out.println("Invalid account type.");
                    return;
            }

            account.createAccount(name, email, phoneNumber, initialBalance);

            System.out.println("Account created successfully!");
            System.out.println(account);
        } catch (AccountException e) {
            System.out.println("Account creation failed: " + e.getMessage());
        }
    }
}