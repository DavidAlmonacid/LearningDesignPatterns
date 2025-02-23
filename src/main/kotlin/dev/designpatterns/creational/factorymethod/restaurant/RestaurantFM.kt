package dev.designpatterns.creational.factorymethod.restaurant

/*
 * ! Factory Method:
 * El patrón Factory Method permite crear objetos sin especificar
 * la clase exacta del objeto que se creará.
 *
 * En lugar de eso, delegamos la creación de objetos a subclases o métodos
 * que encapsulan esta lógica.
 *
 * * Es útil cuando una clase no puede anticipar la clase
 * * de objetos que debe generar.
 *
 * https://refactoring.guru/es/design-patterns/factory-method
 */

/*
 * How to Implement
 *
 * 1. Make all products follow the same interface. This interface should
 * declare methods that make sense in every product.
 *
 * 2. Add an empty factory method inside the creator class. The return type of
 * the method should match the common product interface.
 *
 * 3. In the creator's code, find all references to product constructors. One
 * by one, replace them with calls to the factory method, while extracting the
 * product creation code into the factory method.
 *
 * 4. Now, create a set of creator subclasses for each type of product listed
 * in the factory method. Override the factory method in the subclasses and
 * extract the appropriate bits of construction code from the base method.
 *
 * 5. If there are too many product types, and it doesn’t make sense to create
 * subclasses for all of them, you can reuse the control parameter from the base
 * class in subclasses.
 *
 * 6. If, after all the extractions, the base factory method has become
 * empty, you can make it abstract. If there’s something left, you can make it
 * a default behavior of the method.
 */

// 1. Product interface
interface Hamburger {
    fun prepare()
}

// 1. Concrete Product
class ChickenHamburger : Hamburger {
    override fun prepare() = println("Preparing Chicken Hamburger...")
}

// 1. Concrete Product
class BeefHamburger : Hamburger {
    override fun prepare() = println("Preparing Beef Hamburger...")
}

// 1. Concrete Product
class BeanHamburger : Hamburger {
    override fun prepare() = println("Preparing Bean Hamburger...")
}

// 2. Creator class
abstract class Restaurant {
    // 2. Empty factory method
    protected abstract fun createHamburger(): Hamburger

    // 3. Replace direct product instantiation with a factory method call
    fun orderHamburger() {
        val hamburger = createHamburger() // 3. Factory method call
        hamburger.prepare()
    }
}

// 4. Concrete Creator
class ChickenRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger = ChickenHamburger() // 4. Override factory method
}

// 4. Concrete Creator
class BeefRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger = BeefHamburger() // 4. Override factory method
}

// 4. Concrete Creator
class BeanRestaurant : Restaurant() {
    override fun createHamburger(): Hamburger = BeanHamburger() // 4. Override factory method
}
