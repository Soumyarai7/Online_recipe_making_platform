package com.recipeplatform.service;

import com.recipeplatform.model.Recipe;

public interface RecipeService {
    // Method to save a new recipe
    void saveRecipe(Recipe recipe);

    // Additional methods can be added as needed, such as:
    // Recipe getRecipeById(int id);
    // List<Recipe> getAllRecipes();
    // void updateRecipe(Recipe recipe);
    // void deleteRecipe(int id);
}
