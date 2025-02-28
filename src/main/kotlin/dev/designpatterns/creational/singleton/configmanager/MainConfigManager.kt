package dev.designpatterns.creational.singleton.configmanager

fun main() {
    println("\n -- Singleton Pattern - Challenge 2!!! -- \n")

    val config = ConfigManager
    config.setConfig("apiURL", "http://localhost:3000/api")
    config.setConfig("timeout", "5000")
    config.setConfig("apikey", "ABC123")
    config.setConfig("hola", "hola hola")

    println("apiURL: " + config.getConfig("apiURL"))
    println("timeout: " + config.getConfig("timeout"))

    println(config.getAllConfig())
}
