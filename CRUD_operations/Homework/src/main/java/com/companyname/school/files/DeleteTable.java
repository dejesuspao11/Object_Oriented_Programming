package com.companyname.school.files;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTable {
    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Students WHERE Id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, studentId);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
