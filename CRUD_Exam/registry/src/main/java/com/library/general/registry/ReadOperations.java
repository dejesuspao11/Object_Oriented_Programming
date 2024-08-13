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

            while (resultSet.next()) {
                int codLibro = resultSet.getInt("CodLibro");
                String titulo = resultSet.getString("Titulo");
                String autor = resultSet.getString("Autor");
                String editorial = resultSet.getString("Editorial");

                System.out.println("CodLibro: " + codLibro + ", Titulo: " + titulo + ", Autor: " + autor + ", Editorial: " + editorial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readReaders() {
        String selectReadersSQL = "SELECT * FROM Readers";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectReadersSQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String nombreLector = resultSet.getString("NombreLector");

                System.out.println("Id: " + id + ", NombreLector: " + nombreLector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
