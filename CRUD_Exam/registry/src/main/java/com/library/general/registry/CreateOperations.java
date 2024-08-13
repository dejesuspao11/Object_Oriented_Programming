package com.library.general.registry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateOperations {

    public void createBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CodLibro: ");
        int codLibro = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Enter Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Enter Editorial: ");
        String editorial = scanner.nextLine();

        String insertBookSQL = "INSERT INTO Books (CodLibro, Titulo, Autor, Editorial) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertBookSQL)) {

            preparedStatement.setInt(1, codLibro);
            preparedStatement.setString(2, titulo);
            preparedStatement.setString(3, autor);
            preparedStatement.setString(4, editorial);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new book was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter NombreLector: ");
        String nombreLector = scanner.nextLine();

        String insertReaderSQL = "INSERT INTO Readers (NombreLector) VALUES (?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertReaderSQL)) {

            preparedStatement.setString(1, nombreLector);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new reader was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
