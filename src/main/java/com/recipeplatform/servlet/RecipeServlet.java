package com.recipeplatform.servlet;

import com.recipeplatform.model.Recipe;
import com.recipeplatform.dao.RecipeDao;
import com.recipeplatform.dao.JdbcRecipeDao;
import com.recipeplatform.service.RecipeService;
import com.recipeplatform.service.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RecipeServlet extends HttpServlet {

    private RecipeService recipeService;

    @Override
    public void init() throws ServletException {
        // Create a RecipeDao instance (replace with your implementation)
        RecipeDao recipeDao = new JdbcRecipeDao(); // Assuming you have a JdbcRecipeDao class

        // Create a RecipeService instance with the RecipeDao
        recipeService = new RecipeServiceImpl(recipeDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the recipe submission page (JSP form)
        request.getRequestDispatcher("/submit_recipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data from the request
        int userId = Integer.parseInt(request.getParameter("userId")); // User ID of the recipe creator
        String recipeName = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");

        // Create a new Recipe object with the form data
        Recipe recipe = new Recipe(userId, recipeName, ingredients, instructions);

        // Save the recipe using RecipeService
        recipeService.saveRecipe(recipe);

        // Redirect to a success page or display a success message
        response.sendRedirect("recipe_success.jsp");
    }
}
