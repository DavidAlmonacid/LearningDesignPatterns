package dev.designpatterns.structural.adapter.logger

fun main() {
    println("\n -- Adapter Pattern -- \n")

    val logger = LoggerAdapterImpl("MainLoggerAdapter")

    logger.writeLog(1_000_000, 0.45, Dog("Junior"), Cat("pancho"), Cat("frida"))
    logger.writeDebug(listOf("dogs", "cats"), isCat("frida"), isDog("Pancho"))
    logger.writeError("Set", setOf("junior", "junior", "pancho", "frida"))
    logger.writeWarning("Map", mapOf("first" to "junior", "second" to "pancho", "third" to "frida"))
}

data class Dog(private val name: String)
data class Cat(private val name: String)

fun isCat(name: String): Boolean {
    return name.lowercase() == "frida" || name.lowercase() == "pancho"
}

fun isDog(name: String): Boolean {
    return name.lowercase() == "junior"
}
