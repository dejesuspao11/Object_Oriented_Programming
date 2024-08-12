package com.companyname.school.files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Update URL to match MariaDB
    private static final String URL = "jdbc:mariadb://localhost:3306/SchoolDB";
    private static final String USER = "root"; // Adjust if needed
    private static final String PASSWORD = "admin"; // Adjust if needed

    public static Connection getConnection() throws SQLException {
        try {
            // Ensure the MariaDB driver is loaded
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MariaDB Driver not found.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
