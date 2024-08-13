package com.library.general.registry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteOperations {

    private final Scanner scanner;

    // Constructor to initialize Scanner
    public DeleteOperations(Scanner scanner) {
        this.scanner = scanner;
    }

    public void deleteBook() {
        System.out.print("Enter CodLibro of the book to delete: ");
        int codLibro = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                codLibro = scanner.nextInt();
                scanner.nextLine(); // consume newline
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for CodLibro.");
                scanner.nextLine(); // clear the invalid input
            }
        }

        String deleteBookSQL = "DELETE FROM Books WHERE CodLibro = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteBookSQL)) {

            preparedStatement.setInt(1, codLibro);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("No book found with CodLibro: " + codLibro);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error while deleting book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteReader() {
        System.out.print("Enter ReaderID of the reader to delete: ");
        int readerID = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                readerID = scanner.nextInt();
                scanner.nextLine(); // consume newline
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for ReaderID.");
                scanner.nextLine(); // clear the invalid input
            }
        }

        String deleteReaderSQL = "DELETE FROM Readers WHERE ReaderID = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteReaderSQL)) {

            preparedStatement.setInt(1, readerID);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reader deleted successfully!");
            } else {
                System.out.println("No reader found with ReaderID: " + readerID);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error while deleting reader: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
