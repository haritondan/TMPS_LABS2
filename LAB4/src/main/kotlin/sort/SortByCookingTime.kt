package sort

import models.Recipe

class SortByCookingTime : SortStrategy() {
    override fun sort(recipes: List<Recipe>): List<Recipe> {
        return recipes.sortedBy { it.cookingTime }
    }
}