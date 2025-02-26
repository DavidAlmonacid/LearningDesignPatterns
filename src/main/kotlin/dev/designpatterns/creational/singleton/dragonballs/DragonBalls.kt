package dev.designpatterns.creational.singleton.dragonballs

/*
! Singleton:
Es un patrón de diseño creacional que garantiza que una clase
tenga una única instancia y proporciona un punto de acceso global a ella.

* Es útil cuando necesitas controlar el acceso a una única instancia
* de una clase, por ejemplo, en un objeto de base de datos o en un
* objeto de algún tipo de configuración.

https://refactoring.guru/es/design-patterns/singleton
 */

object DragonBalls {
    var collectedBalls: Int = 0

    init {
        println("New DragonBalls instance has been created\n")
    }

    fun collectBall(): String {
        return if (collectedBalls < 7) {
            collectedBalls++
            "Dragon Balls: $collectedBalls"
        } else {
            "All Dragon Balls have been collected!"
        }
    }

    fun summonShenlong(): String {
        println("\nSummoning!!!")
        println("Current Dragon Balls: $collectedBalls")

        return if (collectedBalls == 7) {
            collectedBalls = 0
            "🫠 Shenlong has been summoned! Make your wish!"
        } else {
            "🫤 You need to collect 7 Dragon Balls to summon Shenlong!"
        } + '\n'
    }
}
