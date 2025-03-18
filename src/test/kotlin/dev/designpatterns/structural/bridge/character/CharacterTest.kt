package dev.designpatterns.structural.bridge.character

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CharacterTest {

    private val originalOut: PrintStream = System.out
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `test Warrior to perform Ability`() {
        // Test using SwordAttack then AxeAttack
        val warrior = Warrior(SwordAttack())
        warrior.performAbility()

        warrior.ability = AxeAttack()
        warrior.performAbility()

        val output = outputStream.toString()

        // Assert that the printed output contains the expected messages
        assertTrue(output.contains("The warrior is ready to fight"))
        assertTrue(output.contains("* Attacks fiercely with a Sword"))
        assertTrue(output.contains("* Attacks brutally with an Axe"))
    }

    @Test
    fun `test Mage to perform Ability`() {
        // Test using FireBallSpell then MagicSpell
        val mage = Mage(FireBallSpell())
        mage.performAbility()

        mage.ability = MagicSpell()
        mage.performAbility()

        val output = outputStream.toString()

        // Assert that the printed output contains the expected messages
        assertTrue(output.contains("The Mage prepares to cast a spell"))
        assertTrue(output.contains("* Throws a large Fireball"))
        assertTrue(output.contains("* Casts a powerful Magic Spell"))
    }
}
