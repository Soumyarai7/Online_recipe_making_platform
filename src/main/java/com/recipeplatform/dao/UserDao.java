package com.recipeplatform.dao;

import com.example.Recipe.User;

public interface UserDao {
    // Method to save a new user in the database
    void saveUser(com.recipeplatform.servlet.User user);

    // Method to retrieve a user by their username
    User getUserByUsername(String username);

    void saveUser(com.recipeplatform.servlet.User user);
}
