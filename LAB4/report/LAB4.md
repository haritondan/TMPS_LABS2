# Topic: *Behavioral Design Patterns*

Author: *Dan Hariton*
------
## Objectives:
1. Study and understand the Behavioral Design Patterns.
2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.
3. Implement some additional functionalities, or create a new project using structural design patterns.

## Theoretical background:
Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

## Main tasks:
&ensp; &ensp; __1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

&ensp; &ensp; __2. Select a domain area for the sample project.__

&ensp; &ensp; __3. Define the main involved classes and think about what instantiation mechanisms are needed.__

&ensp; &ensp; __4. Based on the previous point, implement at least 2 behavioral design patterns in your project.__

# Implementation description:
## Project domain
- an recipe organiser

## Design Patterns
- Observer Pattern: a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

- Command Pattern: a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

- Strategy Pattern: a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.


## Code logic
### Observer Pattern
The RecipeList and RecipeNotifier classes demonstrate a clear implementation of the Observer pattern. RecipeList (the subject) maintains a list of observers and notifies them when a new recipe is added. RecipeNotifier (the observer) updates its state (prints a message) when it's notified of a change in RecipeList.
- RecipeList.kt
```kotlin
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
```
### Command Pattern
The AddToFavorites and ShareRecipe classes encapsulate actions as objects, which is the essence of the Command pattern. These command objects can be used interchangeably, and new commands can be added without modifying the existing code.
- AddToFavorites.kt
```kotlin
class AddToFavorites(private val recipe: Recipe) : Command {
    override fun execute() {
        println("Added ${recipe.name} to favorites")
    }
}
```

### Strategy Pattern
The SortByCookingTime and SortByNumberOfIngredients classes represent different strategies for sorting recipes. This is a clear implementation of the Strategy pattern, as these strategies can be used interchangeably, and new sorting strategies can be added without modifying the existing code
- SortByCookingTime.kt
```kotlin
class SortByCookingTime : SortStrategy() {
    override fun sort(recipes: List<Recipe>): List<Recipe> {
        return recipes.sortedBy { it.cookingTime }
    }
}
```




# Conclusion:
The Observer pattern provides a robust and flexible structure for creating a one-to-many dependency between objects. In your application, it enables automatic and efficient updates when a new recipe is added, enhancing the responsiveness of your app.

The Command pattern encapsulates requests as objects, allowing your application to parameterize other objects with different requests. This pattern enhances the modularity of your code, making it easier to add, remove, or modify actions without affecting other parts of the code.

The Strategy pattern allows your application to choose from a family of algorithms at runtime. In your case, it provides flexibility in sorting recipes based on different criteria. This pattern makes your code more adaptable and easier to extend with new sorting algorithms.

Moreover, your implementation respects the SOLID principles, which are key to creating maintainable and scalable object-oriented software. Each class has a single responsibility, is open for extension but closed for modification, and depends on abstractions rather than concretions. This makes your code more robust, flexible, and easier to understand and modify.

However, it's important to remember that while design patterns provide valuable guidelines, they should be adapted to fit the specific needs of your application. The quality of a design pattern implementation is determined not only by its adherence to the pattern's structure but also by how well it solves the design problems at hand.

Overall, these design patterns have made our recipe app more robust, flexible, and maintainable. They've allowed me to write code that's easier to understand, modify, and extend, which is a key aspect of good software design.