package com.library.general.registry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateOperations {

    private final Scanner scanner;

    // Constructor to initialize Scanner
    public UpdateOperations(Scanner scanner) {
        this.scanner = scanner;
    }

    public void updateBookTitle() {
        System.out.print("Enter CodLibro of the book to update: ");
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

        System.out.print("Enter new Titulo: ");
        String newTitulo = scanner.nextLine();

        String updateBookTitleSQL = "UPDATE Books SET Titulo = ? WHERE CodLibro = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateBookTitleSQL)) {

            preparedStatement.setString(1, newTitulo);
            preparedStatement.setInt(2, codLibro);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book title updated successfully!");
            } else {
                System.out.println("No book found with CodLibro: " + codLibro);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error while updating book title: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateReaderName() {
        System.out.print("Enter ReaderID of the reader to update: ");
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

        System.out.print("Enter new NombreLector: ");
        String newNombreLector = scanner.nextLine();

        String updateReaderNameSQL = "UPDATE Readers SET NombreLector = ? WHERE ReaderID = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateReaderNameSQL)) {

            preparedStatement.setString(1, newNombreLector);
            preparedStatement.setInt(2, readerID);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reader name updated successfully!");
            } else {
                System.out.println("No reader found with ReaderID: " + readerID);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error while updating reader name: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
