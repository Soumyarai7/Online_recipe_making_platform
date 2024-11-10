package com.recipeplatform.model;

public class Recipe {
    private int id; // Unique identifier for the recipe
    private int userId; // User who created the recipe
    private String name; // Name of the recipe
    private String ingredients; // Ingredients required for the recipe
    private String instructions; // Cooking instructions

    // Constructor to initialize a new Recipe
    public Recipe(int userId, String name, String ingredients, String instructions) {
        this.userId = userId;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Default constructor
    public Recipe() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    // Additional methods (if needed) can be added here, such as for validation
}
