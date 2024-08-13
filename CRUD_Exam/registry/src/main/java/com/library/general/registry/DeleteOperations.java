package com.library.general.registry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteOperations {

    public void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CodLibro of the book to delete: ");
        int codLibro = scanner.nextInt();

        String deleteBookSQL = "DELETE FROM Books WHERE CodLibro = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteBookSQL)) {

            preparedStatement.setInt(1, codLibro);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id of the reader to delete: ");
        int id = scanner.nextInt();

        String deleteReaderSQL = "DELETE FROM Readers WHERE Id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteReaderSQL)) {

            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Reader deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
