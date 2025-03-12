package dev.designpatterns.structural.decorator.character

fun main() {
    println("\n -- Decorator Pattern - Challenge!!! -- \n")

    // Create a basic character
    var character: Character = BasicCharacter()
    println("\nInicial character: ${character.getDescription()}")
    println("Stats: ${character.getStats()}")

    // Add a helmet
    character = HelmetDecorator(character)
    println("\nWith Helmet: ${character.getDescription()}")
    println("Stats: ${character.getStats()}")

    // Add a shield
    character = ShieldDecorator(character)
    println("\nWith Shield: ${character.getDescription()}")
    println("Stats: ${character.getStats()}")

    // Add a sword
    character = SwordDecorator(character)
    println("\nWith Sword: ${character.getDescription()}")
    println("Stats: ${character.getStats()}")

    character = RingDecorator(character)
    println("\nWith Ring: ${character.getDescription()}")
    println("Stats: ${character.getStats()}")
}
