// Handle Recipe Form Submission
document.getElementById('recipeForm')?.addEventListener('submit', function (event) {
    event.preventDefault();

    const recipeName = document.getElementById('recipeName').value.trim();
    const ingredients = document.getElementById('ingredients').value.trim();
    const instructions = document.getElementById('instructions').value.trim();

    if (!recipeName || !ingredients || !instructions) {
        alert('Please fill out all fields!');
        return;
    }

    // Add the recipe to the list (for demonstration purposes)
    const recipeList = document.getElementById('recipeList');
    const newRecipe = document.createElement('li');
    newRecipe.className = 'list-group-item';
    newRecipe.textContent = recipeName;
    recipeList.appendChild(newRecipe);

    alert('Recipe submitted successfully!');
    document.getElementById('recipeForm').reset();
});

// Interactive Navbar
document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', function () {
        document.querySelectorAll('.nav-link').forEach(nav => nav.classList.remove('active'));
        this.classList.add('active');
    });
});
