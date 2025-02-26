package dev.designpatterns.creational.singleton.dragonballs

fun main() {
    println("\n -- Singleton Pattern -- \n")

    val gokuDragonBalls = DragonBalls
    repeat(3) {
        println(gokuDragonBalls.collectBall())
    }

    println(gokuDragonBalls.summonShenlong())

    val vegetaDragonBalls = DragonBalls
    repeat(4) {
        println(vegetaDragonBalls.collectBall())
    }

    println(gokuDragonBalls.summonShenlong())
    println(vegetaDragonBalls.summonShenlong())
}
