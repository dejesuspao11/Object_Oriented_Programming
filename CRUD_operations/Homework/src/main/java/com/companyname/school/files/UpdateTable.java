package com.companyname.school.files;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateTable {
    public void updateStudentMajor(int studentId, String newMajor) {
        String query = "UPDATE Students SET Major = ? WHERE Id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, newMajor);
            preparedStatement.setInt(2, studentId);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
