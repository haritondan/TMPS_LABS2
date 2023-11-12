package sort

import models.Recipe

class SortByNumberOfIngredients : SortStrategy() {
    override fun sort(recipes: List<Recipe>): List<Recipe> {
        return recipes.sortedBy { it.ingredients.size }
    }
}