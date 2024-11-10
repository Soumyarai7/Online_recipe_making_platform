package com.recipeplatform.service;

import com.recipeplatform.dao.UserDao;
import com.recipeplatform.servlet.User;

public class UserService {

    private final UserDao userDao;

    // Constructor injection for UserDao
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    // Method to register a new user
    public boolean registerUser(User user) {
        // Check if the username already exists
        if (userDao.getUserByUsername(user.getUsername()) == null) {
            userDao.saveUser(user);
            return true; // Registration successful
        }
        return false; // Username already exists
    }

    // Method to login user and verify credentials
    public com.example.Recipe.User loginUser(String username, String password) {
        com.example.Recipe.User user = userDao.getUserByUsername(username);

        // Verify the password (consider using hashing for production)
        if (user != null && user.getPassword().equals(password)) {
            return user; // Successful login
        }
        return null; // Login failed
    }
}
