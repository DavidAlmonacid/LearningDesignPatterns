package dev.designpatterns.creational.prototype.pokemon

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class PokemonTest {
    @Test
    fun `test pokemon cloning`() {
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

        // Verify that the cloned Pokémon is a different instance
        assertNotSame(pokemon1, pokemon2)

        // Verify that the content of the cloned Pokémon is as expected
        assertEquals("Scizor", pokemon2.name)
        assertEquals(listOf(PokemonType.Bug, PokemonType.Steel), pokemon2.types)
        assertEquals(30.toUByte(), pokemon2.level)
        assertEquals(listOf("Bullet Punch", "Metal Claw", "Fury Cutter", "Slash"), pokemon2.movements)

        // Verify that the original Pokémon remains unchanged
        assertEquals("Scyther", pokemon1.name)
        assertEquals(listOf(PokemonType.Bug, PokemonType.Flying), pokemon1.types)
        assertEquals(5.toUByte(), pokemon1.level)
        assertEquals(listOf("Vacuum Wave", "Quick Attack", "Leer", "Focus Energy"), pokemon1.movements)
    }

    @Test
    fun `test deep cloning of movements`() {
        val pokemon1 = Pokemon(
            name = "Pikachu",
            types = listOf(PokemonType.Electric),
            level = 10u,
            movements = listOf("Thunder Shock", "Quick Attack")
        )

        val pokemon2 = pokemon1.copy(
            movements = pokemon1.movements.toMutableList().apply { add("Iron Tail") }
        )

        // Verify that the cloned Pokémon is a different instance
        assertNotSame(pokemon1, pokemon2)

        // Verify that the movements list is deeply cloned
        assertNotSame(pokemon1.movements, pokemon2.movements)
        assertEquals(listOf("Thunder Shock", "Quick Attack", "Iron Tail"), pokemon2.movements)
        assertEquals(listOf("Thunder Shock", "Quick Attack"), pokemon1.movements)
    }

    @Test
    fun `test pokemon with no types`() {
        assertFailsWith<IllegalArgumentException> {
            Pokemon(
                name = "Ditto",
                types = emptyList(),
                level = 5u,
                movements = listOf("Transform")
            )
        }
    }

    @Test
    fun `test pokemon with more than two types`() {
        assertFailsWith<IllegalArgumentException> {
            Pokemon(
                name = "Eevee",
                types = listOf(PokemonType.Normal, PokemonType.Fairy, PokemonType.Water),
                level = 5u,
                movements = listOf("Tackle", "Tail Whip")
            )
        }
    }

    @Test
    fun `test pokemon with exactly one type`() {
        val pokemon = Pokemon(
            name = "Charmander",
            types = listOf(PokemonType.Fire),
            level = 5u,
            movements = listOf("Scratch", "Growl")
        )

        assertEquals(1, pokemon.types.size)
    }

    @Test
    fun `test pokemon with two types`() {
        val pokemon = Pokemon(
            name = "Bulbasaur",
            types = listOf(PokemonType.Grass, PokemonType.Poison),
            level = 5u,
            movements = listOf("Tackle", "Growl")
        )

        assertEquals(2, pokemon.types.size)
    }
}
