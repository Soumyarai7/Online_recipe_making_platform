<!DOCTYPE html>
<html>
<head>
    <title>Login - Recipe Platform</title>
</head>
<body>
    <h2>Login to Recipe Platform</h2>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    
    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>
</html>
