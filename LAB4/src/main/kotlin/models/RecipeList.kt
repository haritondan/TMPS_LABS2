package models

import interfaces.RecipeObserver
import interfaces.RecipeSubject

class RecipeList : RecipeSubject {
    private val recipes = mutableListOf<Recipe>()
    private val observers = mutableListOf<RecipeObserver>()

    override fun registerObserver(observer: RecipeObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: RecipeObserver) {
        observers.remove(observer)
    }

    override fun notifyObservers(newRecipe: Recipe) {
        observers.forEach { it.update(newRecipe) }
    }

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
        notifyObservers(recipe)
    }
}