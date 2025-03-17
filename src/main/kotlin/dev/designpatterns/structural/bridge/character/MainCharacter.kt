package dev.designpatterns.structural.bridge.character

fun main() {
    println("\n -- Bridge Pattern -- \n")

    val warrior = Warrior(SwordAttack())
    warrior.performAbility()

    warrior.ability = AxeAttack()
    warrior.performAbility()

    val mage = Mage(FireBallSpell())
    mage.performAbility()

    mage.ability = MagicSpell()
    mage.performAbility()
}
