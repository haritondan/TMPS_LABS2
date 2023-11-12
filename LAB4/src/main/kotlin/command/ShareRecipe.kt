package command

import interfaces.Command
import models.Recipe

class ShareRecipe(private val recipe: Recipe) : Command {
    override fun execute() {
        println("Shared ${recipe.name}")
    }
}