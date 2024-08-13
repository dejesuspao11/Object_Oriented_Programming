package com.library.general.registry;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreateOperations createOperations = new CreateOperations();
        ReadOperations readOperations = new ReadOperations();
        UpdateOperations updateOperations = new UpdateOperations();
        DeleteOperations deleteOperations = new DeleteOperations();

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Reader");
            System.out.println("3. View Books");
            System.out.println("4. View Readers");
            System.out.println("5. Update Book Title");
            System.out.println("6. Update Reader Name");
            System.out.println("7. Delete Book");
            System.out.println("8. Delete Reader");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

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
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
