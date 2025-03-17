package dev.designpatterns.structural.bridge.character

abstract class Character(var ability: Ability) {

    abstract fun performAbility()
}

class Warrior(ability: Ability) : Character(ability) {

    override fun performAbility() {
        println("The warrior is ready to fight")
        ability.use()
        println()
    }
}

class Mage(ability: Ability) : Character(ability) {

    override fun performAbility() {
        println("The Mage prepares to cast a spell")
        ability.use()
        println()
    }
}
