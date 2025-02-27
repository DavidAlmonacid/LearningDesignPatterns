package dev.designpatterns.creational.singleton.databaseconnection

fun main() {
    println("\n -- Singleton Pattern - Challenge 1!!! -- \n")

    val db1 = DatabaseConnection
    db1.connect()

    val db2 = DatabaseConnection
    db2.connect()

    db1.disconnect()
    db2.disconnect()

    db2.connect()
}
