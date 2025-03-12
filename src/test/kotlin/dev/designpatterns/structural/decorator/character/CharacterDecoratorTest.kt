package dev.designpatterns.structural.decorator.character

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CharacterDecoratorTest {

    @Test
    fun `should increase the Character defense by 5 when it's decorated with a Helmet`() {
        var character: Character = BasicCharacter()
        character = HelmetDecorator(character)

        val stats = character.getStats()

        assertEquals(15, stats.defense)
    }

    @Test
    fun `should increase the Character defense by 10 when it's decorated with a Shield`() {
        var character: Character = BasicCharacter()
        character = ShieldDecorator(character)

        val stats = character.getStats()

        assertEquals(20, stats.defense)
    }

    @Test
    fun `should increase the Character attack by 7 when it's decorated with a Sword`() {
        var character: Character = BasicCharacter()
        character = SwordDecorator(character)

        val stats = character.getStats()

        assertEquals(17, stats.attack)
    }

    @Test
    fun `should increase the Character attack by 3 when it's decorated with a Ring`() {
        var character: Character = BasicCharacter()
        character = RingDecorator(character)

        val stats = character.getStats()

        assertEquals(13, stats.attack)
    }

    @Test
    fun `should get the max possile stats when it's decorated with all the decorators`() {
        var character: Character = BasicCharacter()
        character = HelmetDecorator(character)
        character = ShieldDecorator(character)
        character = SwordDecorator(character)
        character = RingDecorator(character)

        val expectedStats = Stats(attack = 20, defense = 25)

        assertEquals(expectedStats, character.getStats())
    }

}
