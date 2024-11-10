<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Submit a Recipe</title>
</head>
<body>
    <h2>Submit Your Recipe</h2>
    <form action="submitRecipe" method="post">
        <label for="recipeName">Recipe Name:</label>
        <input type="text" id="recipeName" name="recipeName" required><br><br>
        
        <label for="ingredients">Ingredients:</label><br>
        <textarea id="ingredients" name="ingredients" rows="5" cols="40" required></textarea><br><br>
        
        <label for="instructions">Instructions:</label><br>
        <textarea id="instructions" name="instructions" rows="5" cols="40" required></textarea><br><br>
        
        <label for="category">Category:</label>
        <select name="category" id="category">
            <option value="appetizer">Appetizer</option>
            <option value="main_course">Main Course</option>
            <option value="dessert">Dessert</option>
            <!-- Add more categories as needed -->
        </select><br><br>
        
        <label for="prepTime">Preparation Time (in minutes):</label>
        <input type="number" id="prepTime" name="prepTime" required><br><br>
        
        <label for="cookTime">Cooking Time (in minutes):</label>
        <input type="number" id="cookTime" name="cookTime" required><br><br>

        <label for="image">Recipe Image (Optional):</label>
        <input type="file" id="image" name="image"><br><br>

        <input type="submit" value="Submit Recipe">
    </form>
</body>
</html>
