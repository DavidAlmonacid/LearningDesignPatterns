package dev.designpatterns.creational.abstractfactory.restaurant

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class RestaurantAFTest {
    @Test
    fun `test FastFoodRestaurantFactory`() {
        val factory: RestaurantFactory = FastFoodRestaurantFactory
        val hamburger = factory.createHamburger()
        val drink = factory.createDrink()

        assertTrue(hamburger is BeefHamburger)
        assertTrue(drink is Soda)
    }

    @Test
    fun `test HealthyFoodRestaurantFactory`() {
        val factory: RestaurantFactory = HealthyFoodRestaurantFactory
        val hamburger = factory.createHamburger()
        val drink = factory.createDrink()

        assertTrue(hamburger is ChickenHamburger)
        assertTrue(drink is Water)
    }
}
