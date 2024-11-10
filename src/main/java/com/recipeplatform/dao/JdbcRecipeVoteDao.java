package com.recipeplatform.dao;

import java.sql.*;

public class JdbcRecipeVoteDao implements RecipeVoteDao {

    // Method to get database connection
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/recipe_platform";  // Update with your database name
        String user = "root";  // Update with your MySQL username
        String password = "yourpassword";  // Update with your MySQL password

        return DriverManager.getConnection(url, user, password);
    }

    // Save a vote for a recipe
    @Override
    public void saveRecipeVote(RecipeVote vote) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO recipe_votes (user_id, recipe_id, rating) VALUES (?, ?, ?)")) {

            statement.setInt(1, vote.getUserId());
            statement.setInt(2, vote.getRecipeId());
            statement.setInt(3, vote.getRating());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Vote successfully recorded for recipe ID: " + vote.getRecipeId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., log the error or throw a custom exception
        }
    }

    // Get the average rating of a recipe
    @Override
    public double getAverageRating(int recipeId) {
        double averageRating = 0.0;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT AVG(rating) AS average_rating FROM recipe_votes WHERE recipe_id = ?")) {

            statement.setInt(1, recipeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                averageRating = resultSet.getDouble("average_rating");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return averageRating;
    }
}
