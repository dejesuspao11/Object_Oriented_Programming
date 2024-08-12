package com.companyname.school.files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {
    public void createTables() {
        String createStudentsTable = "CREATE TABLE IF NOT EXISTS Students("
                + "Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "Name VARCHAR(30) NOT NULL, "
                + "Major VARCHAR(30) NOT NULL);";

        String createInstructorsTable = "CREATE TABLE IF NOT EXISTS Instructors("
                + "Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "Name VARCHAR(30) NOT NULL, "
                + "Location VARCHAR(30));";

        String createCoursesTable = "CREATE TABLE IF NOT EXISTS Courses("
                + "Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "Name VARCHAR(30) NOT NULL, "
                + "Instructor_Id INT NOT NULL, "
                + "CONSTRAINT fk_instructor_id FOREIGN KEY (Instructor_Id) REFERENCES Instructors(Id));";

        String createCoursesGradesTable = "CREATE TABLE IF NOT EXISTS Courses_Grades("
                + "Student_Id INT NOT NULL, "
                + "Course_Id INT NOT NULL, "
                + "Grade FLOAT NOT NULL, "
                + "CONSTRAINT fk_student_id FOREIGN KEY (Student_Id) REFERENCES Students(Id), "
                + "CONSTRAINT fk_course_id FOREIGN KEY (Course_Id) REFERENCES Courses(Id), "
                + "PRIMARY KEY (Student_Id, Course_Id));";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createStudentsTable);
            statement.execute(createInstructorsTable);
            statement.execute(createCoursesTable);
            statement.execute(createCoursesGradesTable);

            System.out.println("Tables created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        String insertStudentSQL = "INSERT INTO Students (Name, Major) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertStudentSQL)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, major);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Student added successfully. Rows affected: " + rowsAffected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
