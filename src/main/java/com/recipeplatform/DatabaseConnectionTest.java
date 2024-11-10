package com.recipeplatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        // Update the URL, user, and password for your online recipe platform's database
        String url = "jdbc:mysql://localhost:3306/recipe_platform";  // database name: recipe_platform
        String user = "root";  // database username
        String password = "yourpassword";  // update with your actual password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

