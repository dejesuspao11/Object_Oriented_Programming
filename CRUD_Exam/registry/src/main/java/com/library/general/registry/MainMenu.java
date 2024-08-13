package com.library.general.registry;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreateOperations createOperations = new CreateOperations(scanner);
        ReadOperations readOperations = new ReadOperations();
        UpdateOperations updateOperations = new UpdateOperations(scanner);
        DeleteOperations deleteOperations = new DeleteOperations(scanner);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Reader");
            System.out.println("3. View Books");
            System.out.println("4. View Readers");
            System.out.println("5. Update Book Title");
            System.out.println("6. Update Reader Name");
            System.out.println("7. Delete Book");
            System.out.println("8. Delete Reader");
            System.out.println("9. Exit");

            int choice = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter your choice: ");
                try {
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        if (choice >= 1 && choice <= 9) {
                            validInput = true;
                        } else {
                            System.out.println("Invalid choice. Please enter a number between 1 and 9.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // clear invalid input
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // clear invalid input
                }
            }

            switch (choice) {
                case 1:
                    createOperations.createBook();
                    break;
                case 2:
                    createOperations.createReader();
                    break;
                case 3:
                    readOperations.readBooks();
                    break;
                case 4:
                    readOperations.readReaders();
                    break;
                case 5:
                    updateOperations.updateBookTitle();
                    break;
                case 6:
                    updateOperations.updateReaderName();
                    break;
                case 7:
                    deleteOperations.deleteBook();
                    break;
                case 8:
                    deleteOperations.deleteReader();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close(); // Close the scanner when done
                    return; // Exit the program
                default:
                    System.out.println("Unexpected error. Please try again.");
            }
        }
    }
}
