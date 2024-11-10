package com.recipeplatform.service;

import com.recipeplatform.dao.RecipeDao;
import com.recipeplatform.model.Recipe;

public class RecipeServiceImpl implements RecipeService {

    private final RecipeDao recipeDao;

    // Constructor to inject the RecipeDao dependency
    public RecipeServiceImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    // Implementation of the saveRecipe method
    @Override
    public void saveRecipe(Recipe recipe) {
        System.out.println("Saving recipe: " + recipe.getName());
        ((RecipeServiceImpl) recipeDao).saveRecipe(recipe);
    }

    // Additional methods can be implemented here based on the RecipeService interface
    // For example:
    // @Override
    // public Recipe getRecipeById(int id) {
    //     return recipeDao.getRecipeById(id);
    // }
}
