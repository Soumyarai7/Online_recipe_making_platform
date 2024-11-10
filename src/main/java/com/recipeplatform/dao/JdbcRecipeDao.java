package com.recipeplatform.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRecipeDao implements RecipeDao {

    // Method to get database connection
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/recipe_platform";  // Update with your database name
        String user = "root";  // Update with your MySQL username
        String password = "yourpassword";  // Update with your MySQL password

        return DriverManager.getConnection(url, user, password);
    }

    // Save a new recipe to the database
    @Override
    public void saveRecipe(Recipe recipe) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO recipes (user_id, title, description, ingredients, steps) VALUES (?, ?, ?, ?, ?)")) {
            System.out.println("Saving recipe: " + recipe.getTitle());

            statement.setInt(1, recipe.getUserId());  // Assuming the user ID is already set
            statement.setString(2, recipe.getTitle());
            statement.setString(3, recipe.getDescription());
            statement.setString(4, recipe.getIngredients());
            statement.setString(5, recipe.getSteps());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new recipe was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a recipe by its ID
    @Override
    public Recipe getRecipeById(int recipeId) {
        Recipe recipe = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipes WHERE recipe_id = ?")) {

            statement.setInt(1, recipeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                recipe = new Recipe();
                recipe.setRecipeId(resultSet.getInt("recipe_id"));
                recipe.setUserId(resultSet.getInt("user_id"));
                recipe.setTitle(resultSet.getString("title"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setIngredients(resultSet.getString("ingredients"));
                recipe.setSteps(resultSet.getString("steps"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the error or throwing a custom exception
        }
        return recipe;
    }

    // Retrieve all recipes
    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM recipes")) {

            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setRecipeId(resultSet.getInt("recipe_id"));
                recipe.setUserId(resultSet.getInt("user_id"));
                recipe.setTitle(resultSet.getString("title"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setIngredients(resultSet.getString("ingredients"));
                recipe.setSteps(resultSet.getString("steps"));
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }
}
