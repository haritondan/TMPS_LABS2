package interfaces

import models.Recipe

interface RecipeSubject {
    fun registerObserver(observer: RecipeObserver)
    fun removeObserver(observer: RecipeObserver)
    fun notifyObservers(newRecipe: Recipe)
}