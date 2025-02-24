package dev.designpatterns.creational.abstractfactory.restaurant

/*
! Abstract Factory:

Es un patrón de diseño que permite crear familias de objetos relacionados
sin especificar sus clases concretas.

En lugar de generar objetos individuales directamente,
creamos fábricas que producen un conjunto de objetos relacionados.

* Es útil cuando necesitas generar objetos que son parte de una familia
* y quieres asegurarte de que estos objetos se complementen entre sí.

https://refactoring.guru/es/design-patterns/abstract-factory
 */

/*
El propósito del Abstract Factory es crear familias de objetos relacionados
(en este caso, hamburguesas y bebidas) sin especificar las clases concretas
de cada uno de esos objetos en el código principal.
 */

/*
How to Implement

1. Declare abstract product interfaces for all product types. Then make all
concrete product classes implement these interfaces.

2. Declare the abstract factory interface with a set of creation methods for all
abstract products.

3. Implement a set of concrete factory classes, one for each product variant.
 */

// 1. Declare abstract product interfaces for all product types ↓↓↓

/**
 * Abstract product interface for Hamburger.
 */
interface Hamburger {
    fun prepare()
}

/**
 * Abstract product interface for Drink.
 */
interface Drink {
    fun pour()
}

// 1. Concrete products that implement interfaces ↓↓↓

/**
 * Concrete product implementation for Hamburger.
 */
class ChickenHamburger : Hamburger {
    override fun prepare() = println("Preparing Chicken Hamburger...")
}

/**
 * Concrete product implementation for Hamburger.
 */
class BeefHamburger : Hamburger {
    override fun prepare() = println("Preparing Beef Hamburger...")
}

/**
 * Concrete product implementation for Drink.
 */
class Water : Drink {
    override fun pour() = println("Pouring water...")
}

/**
 * Concrete product implementation for Drink.
 */
class Soda : Drink {
    override fun pour() = println("Pouring soda...")
}

// 2. Declare the abstract factory interface for all abstract products
/**
 * Abstract factory interface for creating related products.
 */
interface RestaurantFactory {
    fun createHamburger(): Hamburger
    fun createDrink(): Drink
}

// 3. Implement a set of concrete factory classes ↓↓↓

/**
 * Concrete factory for creating fast food products.
 */
object FastFoodRestaurantFactory : RestaurantFactory {
    override fun createHamburger(): Hamburger = BeefHamburger()
    override fun createDrink(): Drink = Soda()
}

/**
 * Concrete factory for creating healthy food products.
 */
object HealthyFoodRestaurantFactory : RestaurantFactory {
    override fun createHamburger(): Hamburger = ChickenHamburger()
    override fun createDrink(): Drink = Water()
}
