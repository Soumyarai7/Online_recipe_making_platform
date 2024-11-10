package com.recipeplatform.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    // Using UserService to handle registration logic
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService(new JdbcUserDao());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the registration page (JSP)
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a new User object and set the username and password
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Register the new user using UserService
        boolean isRegistered = userService.registerUser(user);

        // Handle registration success or failure
        if (isRegistered) {
            response.sendRedirect("registration_success.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Username may already exist.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
