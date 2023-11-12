package interfaces

import models.Recipe

interface RecipeObserver {
    fun update(newRecipe: Recipe)
}