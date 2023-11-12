package models

import interfaces.RecipeObserver

class RecipeNotifier : RecipeObserver {
    override fun update(newRecipe: Recipe) {
        println("New recipe added: ${newRecipe.name}")
    }
}