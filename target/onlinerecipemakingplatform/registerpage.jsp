<!DOCTYPE html>
<html>
<head>
    <title>Register - Recipe Platform</title>
</head>
<body>
    <h2>Register for Recipe Platform</h2>
    <form action="register" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br><br>
        
        <input type="submit" value="Register">
    </form>
    
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>
