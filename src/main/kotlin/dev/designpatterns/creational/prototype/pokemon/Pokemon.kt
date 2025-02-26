package dev.designpatterns.creational.prototype.pokemon

/*
Challenge:

1. Crear un Pokémon básico.
2. Clonar el Pokémon y modificar algunos atributos en los clones.
 */

data class Pokemon(
    val name: String,
    val types: List<PokemonType>,
    val level: UByte,
    val movements: List<String>
) {
    init {
        require(types.size in 1..2) { "A Pokemon must have between 1 and 2 types." }
    }
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
