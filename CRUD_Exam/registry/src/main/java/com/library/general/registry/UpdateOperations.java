package com.library.general.registry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOperations {

    public void updateBookTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CodLibro of the book to update: ");
        int codLibro = scanner.nextInt();
        scanner.nextLine(); // consume newline
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReaderName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id of the reader to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new NombreLector: ");
        String newNombreLector = scanner.nextLine();

        String updateReaderNameSQL = "UPDATE Readers SET NombreLector = ? WHERE Id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateReaderNameSQL)) {

            preparedStatement.setString(1, newNombreLector);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reader name updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
