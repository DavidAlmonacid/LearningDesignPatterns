package dev.designpatterns.creational.prototype.pokemon

fun main() {
    println("\n -- Prototype Pattern - Challenge!!! -- \n")

    val pokemon1 = Pokemon(
        name = "Scyther",
        types = listOf(PokemonType.Bug, PokemonType.Flying),
        level = 5u,
        movements = listOf("Vacuum Wave", "Quick Attack", "Leer", "Focus Energy")
    )

    val pokemon2 = pokemon1.clone()
    pokemon2.name = "Scizor"
    pokemon2.level = 30u
    pokemon2.types = listOf(PokemonType.Bug, PokemonType.Steel)
    pokemon2.movements = listOf("Bullet Punch", "Metal Claw", "Fury Cutter", "Slash")

    val pokemon3 = pokemon1.clone()
    pokemon3.name = "Kleavor"
    pokemon3.level = 36u
    pokemon3.types = listOf(PokemonType.Bug, PokemonType.Rock)
    pokemon3.movements = listOf("Stone Axe", "Double Team", "Double Hit", "Rock Slide")

    println(pokemon1)
    println(pokemon2)
    println(pokemon3)
}
