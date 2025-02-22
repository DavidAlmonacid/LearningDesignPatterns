package dev.designpatterns.creational.factorymethod.restaurant

fun main() {
    println("\n -- Factory Method Pattern -- \n")

    print(
        """Enter a number for the burger you want to order:
1. Chicken Burger
2. Beef Burger
3. Bean Burger

-> """
    )

    val restaurant = createRestaurantFromInput(readlnOrNull()?.trim())
    restaurant.orderHamburger()
}

/**
 * Creates a [Restaurant] instance based on user input.
 *
 * @param burgerType the user input string representing the burger type.
 * @return a [Restaurant] instance.
 * @throws IllegalArgumentException if the provided burger type is invalid.
 */
fun createRestaurantFromInput(burgerType: String?): Restaurant {
    return when (burgerType) {
        "1" -> ChickenRestaurant()
        "2" -> BeefRestaurant()
        "3" -> BeanRestaurant()
        else -> {
            println("Invalid option. Please enter 1, 2, or 3.")
            throw IllegalArgumentException("Invalid option")
        }
    }
}
