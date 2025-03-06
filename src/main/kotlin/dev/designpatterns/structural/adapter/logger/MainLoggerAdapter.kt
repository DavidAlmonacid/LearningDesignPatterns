package dev.designpatterns.structural.adapter.logger

import io.github.oshai.kotlinlogging.KotlinLogging
import java.text.DecimalFormat

fun main() {
    println("\n -- Adapter Pattern -- \n")

    val logger = LoggerAdapterImpl(KotlinLogging.logger("MainLoggerAdapter"))

    logger.writeLog(DecimalFormat("#,###.##").format(1_000_000), 0.45, Dog("Junior"), Cat("pancho"), Cat("frida"))
    logger.writeDebug(listOf("dogs", "cats"), "isCat: " + isCat("frida"), "isDog: " + isDog("Pancho"))
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
