package dev.designpatterns.creational.prototype.pokemon

fun main() {
    println("\n -- Prototype Pattern - Challenge!!! -- \n")

    val pokemon1 = Pokemon(
        name = "Scyther",
        types = listOf(PokemonType.Bug, PokemonType.Flying),
        level = 5u,
        movements = listOf("Vacuum Wave", "Quick Attack", "Leer", "Focus Energy")
    )

    val pokemon2 = pokemon1.copy(
        name = "Scizor",
        level = 30u,
        types = listOf(PokemonType.Bug, PokemonType.Steel),
        movements = listOf("Bullet Punch", "Metal Claw", "Fury Cutter", "Slash")
    )

    val pokemon3 = pokemon1.copy(
        name = "Kleavor",
        level = 36u,
        types = listOf(PokemonType.Bug, PokemonType.Rock),
        movements = listOf("Stone Axe", "Double Team", "Double Hit", "Rock Slide")
    )

    println(pokemon1)
    println(pokemon2)
    println(pokemon3)
}
