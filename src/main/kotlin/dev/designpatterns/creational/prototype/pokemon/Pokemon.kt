package dev.designpatterns.creational.prototype.pokemon

/*
Challenge:

1. Crear un Pokémon básico.
2. Clonar el Pokémon y modificar algunos atributos en los clones.

Ejemplo:
val basePokemon = Pokemon("Charmander", "Fuego", 1, ["Llamarada", "Arañazo"])
val clone1 = basePokemon.clone()
clone1.name = "Charmeleon"
clone1.level = 16
clone1.attacks.push("Lanzallamas")
 */

data class Pokemon(
    var name: String,
    var types: List<PokemonType>,
    var level: UByte,
    var movements: List<String>
) {
    init {
        require(types.size in 1..2) { "A Pokemon must have between 1 and 2 types." }
    }

    // Method to clone the Pokémon
    // Lists should not be passed by reference, i.e., they should not be the same list.
    fun clone(): Pokemon = Pokemon(name, types.toList(), level, movements.toList())
}

enum class PokemonType {
    Bug,
    Dark,
    Dragon,
    Electric,
    Fairy,
    Fighting,
    Fire,
    Flying,
    Ghost,
    Grass,
    Ground,
    Ice,
    Normal,
    Poison,
    Psychic,
    Rock,
    Steel,
    Water
}
