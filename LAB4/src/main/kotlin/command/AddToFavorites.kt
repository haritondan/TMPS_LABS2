package command

import interfaces.Command
import models.Recipe

class AddToFavorites(private val recipe: Recipe) : Command {
    override fun execute() {
        println("Added ${recipe.name} to favorites")
    }
}