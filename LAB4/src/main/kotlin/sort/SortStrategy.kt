package sort

import models.Recipe

abstract class SortStrategy {
    abstract fun sort(recipes: List<Recipe>): List<Recipe>
}