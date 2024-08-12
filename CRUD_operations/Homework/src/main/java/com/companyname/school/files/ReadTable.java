package com.companyname.school.files;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadTable {
    public void readStudents() {
        String query = "SELECT * FROM Students";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("Id") +
                        ", Name: " + resultSet.getString("Name") +
                        ", Major: " + resultSet.getString("Major"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
