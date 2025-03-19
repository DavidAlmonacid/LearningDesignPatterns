package dev.designpatterns.structural.bridge.character

/*
 * ! Patrón Bridge
 * Este patrón nos permite desacoplar una abstracción de su implementación,
 * de tal forma que ambas puedan variar independientemente.
 *
 * * Es útil cuando se tienen múltiples implementaciones de una abstracción.
 * * Se puede utilizar para separar la lógica de negocio de la lógica de
 * * presentación.
 * * Se puede utilizar para separar la lógica de la interfaz de usuario también.
 *
 * https://refactoring.guru/es/design-patterns/bridge
 */

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
