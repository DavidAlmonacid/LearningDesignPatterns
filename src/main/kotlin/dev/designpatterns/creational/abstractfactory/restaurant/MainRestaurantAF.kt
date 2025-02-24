package dev.designpatterns.creational.abstractfactory.restaurant

fun main() {
    println("\n -- Abstract Factory Pattern -- \n")

    println("* Fast Food Restaurant Order")
    createRestaurant(FastFoodRestaurantFactory)

    println("\n* Healthy Food Restaurant Order")
    createRestaurant(HealthyFoodRestaurantFactory)
}

fun createRestaurant(restaurantFactory: RestaurantFactory) {
    val hamburger = restaurantFactory.createHamburger()
    val drink = restaurantFactory.createDrink()

    hamburger.prepare()
    drink.pour()
}
