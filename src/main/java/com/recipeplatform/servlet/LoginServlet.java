package com.recipeplatform.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    // Using UserService to handle login logic
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService(new JdbcUserDao());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the login page (JSP)
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate user using UserService
        User user = ((Object) userService).loginUser(username, password);

        if (user != null) {
            // Store user information in session and redirect to dashboard
            request.getSession().setAttribute("loggedUser", user);
            response.sendRedirect("dashboard.jsp");
        } else {
            // Redirect to login page with an error message
            request.setAttribute("loginError", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
