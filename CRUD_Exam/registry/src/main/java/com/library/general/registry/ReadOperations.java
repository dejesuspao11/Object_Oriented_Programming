package com.library.general.registry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadOperations {

    public void readBooks() {
        String selectBooksSQL = "SELECT * FROM Books";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectBooksSQL)) {

            // Check if any rows were returned
            boolean hasResults = false;
            while (resultSet.next()) {
                hasResults = true;
                int codLibro = resultSet.getInt("CodLibro");
                String titulo = resultSet.getString("Titulo");
                String autor = resultSet.getString("Autor");
                String editorial = resultSet.getString("Editorial");

                System.out.println("CodLibro: " + codLibro + ", Titulo: " + titulo + ", Autor: " + autor + ", Editorial: " + editorial);
            }

            if (!hasResults) {
                System.out.println("No books found.");
            }

        } catch (SQLException e) {
            System.err.println("SQL Error while reading books: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void readReaders() {
        String selectReadersSQL = "SELECT * FROM Readers";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectReadersSQL)) {

            // Check if any rows were returned
            boolean hasResults = false;
            while (resultSet.next()) {
                hasResults = true;
                int readerID = resultSet.getInt("ReaderID");
                String nombreLector = resultSet.getString("NombreLector");

                System.out.println("ReaderID: " + readerID + ", NombreLector: " + nombreLector);
            }

            if (!hasResults) {
                System.out.println("No readers found.");
            }

        } catch (SQLException e) {
            System.err.println("SQL Error while reading readers: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
