package dev.designpatterns.structural.decorator.character

data class Stats(val attack: Int, val defense: Int)

// 1. Character interface
interface Character {
    fun getDescription(): String
    fun getStats(): Stats
}

// 2. BasicCharacter class
class BasicCharacter : Character {

    override fun getDescription(): String {
        return "Basic Character"
    }

    override fun getStats(): Stats {
        return Stats(attack = 10, defense = 10)
    }

}

// 3. CharacterDecorator decorator class
abstract class CharacterDecorator(private val character: Character) : Character {

    override fun getDescription(): String {
        return character.getDescription()
    }

    override fun getStats(): Stats {
        return character.getStats()
    }

}

// 4. HelmetDecorator concrete decorator
/**
 * Adds a helmet that increases defense by 5.
 *
 * Constructor:
 * @param character The Character instance to decorate with a helmet.
 */
class HelmetDecorator(character: Character) : CharacterDecorator(character) {

    override fun getDescription(): String {
        return super.getDescription() + "\n * with Helmet"
    }

    override fun getStats(): Stats {
        val (attack, defense) = super.getStats()
        return Stats(attack = attack, defense = defense + 5)
    }

}

// 5. ShieldDecorator concrete decorator
/**
 * Adds a shield that increases defense by 10.
 *
 * Constructor:
 * @param character The Character instance to decorate with a shield.
 */
class ShieldDecorator(character: Character) : CharacterDecorator(character) {

    override fun getDescription(): String {
        return super.getDescription() + "\n * with Shield"
    }

    override fun getStats(): Stats {
        val (attack, defense) = super.getStats()
        return Stats(attack = attack, defense = defense + 10)
    }

}

// 6. SwordDecorator concrete decorator
/**
 * Adds a sword that increases attack by 7.
 *
 * Constructor:
 * @param character The Character instance to decorate with a sword.
 */
class SwordDecorator(character: Character) : CharacterDecorator(character) {

    override fun getDescription(): String {
        return super.getDescription() + "\n * with Sword"
    }

    override fun getStats(): Stats {
        val (attack, defense) = super.getStats()
        return Stats(attack = attack + 7, defense = defense)
    }

}

/**
 * Adds a ring that increases attack by 3.
 *
 * Constructor:
 * @param character The Character instance to decorate with a ring.
 */
class RingDecorator(character: Character) : CharacterDecorator(character) {

    override fun getDescription(): String {
        return super.getDescription() + "\n * with Ring"
    }

    override fun getStats(): Stats {
        val (attack, defense) = super.getStats()
        return Stats(attack = attack + 3, defense = defense)
    }

}
