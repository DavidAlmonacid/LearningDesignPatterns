package dev.designpatterns

import dev.designpatterns.creational.builder.Computer
import dev.designpatterns.creational.builder.ComputerBuilderImpl
import dev.designpatterns.creational.builder.Direction
import dev.designpatterns.creational.builder.QueryBuilderImpl

fun main() {
    println("\n -- Builder Pattern -- \n")

    val basicComputer: Computer = ComputerBuilderImpl()
        .setCPU("Intel Core i5 12450H")
        .setRAM("16GB")
        .setStorage("512GB SSD")
        .build()

    println("* Basic Computer")
    println(basicComputer)

    val gamingComputer: Computer = ComputerBuilderImpl()
        .setCPU("Intel Core i7 12700K")
        .setRAM("32GB")
        .setStorage("1TB SSD")
        .setDedicatedGPU("Nvidia RTX 3080")
        .build()

    println("\n* Gaming Computer")
    println(gamingComputer)

    val myComputer: Computer = ComputerBuilderImpl()
        .setCPU("Intel Celeron G3930")
        .setRAM("8GB")
        .setStorage("256GB SSD")
        .build()

    println("\n* My Computer")
    println(myComputer)

    println("\n -- Builder Pattern - Challenge!!! -- \n")

    val usersQuery: String = QueryBuilderImpl("users")
        .select("id", "name", "email")
        .where("age > 18")
        .where("country = 'COL'")
        .orderBy(field = "id", direction = Direction.ASC)
        .orderBy(field = "name")
        .orderBy(field = "email", direction = Direction.DESC)
        .limit(10)
        .execute()

    println("* Query:")
    println(usersQuery)
}
