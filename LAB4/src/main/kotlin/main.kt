import command.AddToFavorites
import command.ShareRecipe
import models.Recipe
import models.RecipeList
import models.RecipeNotifier
import sort.SortByCookingTime
import sort.SortByNumberOfIngredients

fun main() {
    val recipes = listOf(
        Recipe("Spaghetti", listOf("Pasta", "Tomato Sauce", "Garlic"), 30),
        Recipe("Grilled Cheese", listOf("Bread", "Cheese", "Butter"), 10),
    )

    val recipeList = RecipeList()
    val recipeNotifier = RecipeNotifier()
    recipeList.registerObserver(recipeNotifier)

    val sortByCookingTime = SortByCookingTime()
    val sortedByCookingTime = sortByCookingTime.sort(recipes)
    println("Sorted by cooking time: ${sortedByCookingTime.map { it.name }}")

    val sortByNumberOfIngredients = SortByNumberOfIngredients()
    val sortedByNumberOfIngredients = sortByNumberOfIngredients.sort(recipes)
    println("Sorted by number of ingredients: ${sortedByNumberOfIngredients.map { it.name }}")

    val recipe = Recipe("Spaghetti", listOf("Pasta", "Tomato Sauce", "Garlic"), 30)
    recipeList.addRecipe(recipe)

    val addToFavoritesCommand = AddToFavorites(recipe)
    addToFavoritesCommand.execute()

    val shareRecipeCommand = ShareRecipe(recipe)
    shareRecipeCommand.execute()
}