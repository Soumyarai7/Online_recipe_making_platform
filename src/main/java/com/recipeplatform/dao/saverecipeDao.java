package com.recipeplatform.dao;

import com.recipeplatform.model.Recipe;

public interface saverecipeDao {
    // Method to save a new recipe in the database
    void saveRecipe(Recipe recipe);

    // Additional methods can be added as needed, such as:
    // Recipe getRecipeById(int id);
    // List<Recipe> getAllRecipes();
    // void updateRecipe(Recipe recipe);
    // void deleteRecipe(int id);
}
