package dev.designpatterns.creational.factorymethod.restaurant

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertTrue

class RestaurantTest {
    // Helper function to capture system output.
    private fun captureOutput(block: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        val oldOut = System.out

        System.setOut(PrintStream(outputStream))
        block()
        System.setOut(oldOut)

        return outputStream.toString().trim()
    }

    @Test
    fun `test ChickenRestaurant orderHamburger prints expected message`() {
        val output = captureOutput { ChickenRestaurant().orderHamburger() }
        assertTrue(output.contains("Preparing Chicken Hamburger..."))
    }

    @Test
    fun `test BeefRestaurant orderHamburger prints expected message`() {
        val output = captureOutput { BeefRestaurant().orderHamburger() }
        assertTrue(output.contains("Preparing Beef Hamburger..."))
    }

    @Test
    fun `test BeanRestaurant orderHamburger prints expected message`() {
        val output = captureOutput { BeanRestaurant().orderHamburger() }
        assertTrue(output.contains("Preparing Bean Hamburger..."))
    }
}
