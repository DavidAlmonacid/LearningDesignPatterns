package dev.designpatterns.creational.factorymethod.restaurant

interface Hamburger {
    fun prepare()
}

class ChickenHamburger : Hamburger {
    override fun prepare() = println("Preparing Chicken Hamburger...")
}

class BeefHamburger : Hamburger {
    override fun prepare() = println("Preparing Beef Hamburger...")
}

class BeanHamburger : Hamburger {
    override fun prepare() = println("Preparing Bean Hamburger...")
}

abstract class Restaurant {
    protected abstract fun createHamburger(): Hamburger

    fun orderHamburger() {
        val hamburger = createHamburger()
        hamburger.prepare()
    }
}

class ChickenRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger = ChickenHamburger()
}

class BeefRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger = BeefHamburger()
}

class BeanRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger = BeanHamburger()
}
