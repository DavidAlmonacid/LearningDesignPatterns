package dev.designpatterns.creational.singleton.dragonballs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DragonBallsTest {
    @BeforeEach
    fun resetDragonBalls() {
        // Reset the collectedBalls to 0 before each test
        DragonBalls.collectedBalls = 0
    }

    @Test
    fun `test collectBall increments collectedBalls`() {
        DragonBalls.collectBall()
        assertEquals(1, DragonBalls.collectedBalls)
    }

    @Test
    fun `test collectBall does not exceed 7`() {
        repeat(8) { DragonBalls.collectBall() }
        assertEquals(7, DragonBalls.collectedBalls)
    }

    @Test
    fun `test summonShenlong with less than 7 balls`() {
        DragonBalls.collectBall()
        val result = DragonBalls.summonShenlong().trim()
        assertEquals("🫤 You need to collect 7 Dragon Balls to summon Shenlong!", result)
    }

    @Test
    fun `test summonShenlong with 7 balls`() {
        repeat(7) { DragonBalls.collectBall() }
        val result = DragonBalls.summonShenlong().trim()
        assertEquals("🫠 Shenlong has been summoned! Make your wish!", result)
        assertEquals(0, DragonBalls.collectedBalls)
    }
}
