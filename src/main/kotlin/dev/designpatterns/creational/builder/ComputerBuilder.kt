package dev.designpatterns.creational.builder

/*
 * ! Patrón Builder:
 * Es un patrón de diseño creacional que nos permite construir objetos complejos
 * paso a paso.
 *
 * El patrón nos permite producir distintos tipos y representaciones
 * de un objeto empleando el mismo código de construcción.
 *
 * * Es útil cuando necesitamos construir un objeto complejo con muchas partes
 * * y queremos que el proceso de construcción sea independiente de las partes
 * * que lo componen.
 *
 * https://refactoring.guru/es/design-patterns/builder
 */

data class Computer(
    val cpu: String,
    val ram: String,
    val storage: String,
    val dedicatedGpu: String? = null
)

interface ComputerBuilder {
    fun setCPU(cpu: String): ComputerBuilder
    fun setRAM(ram: String): ComputerBuilder
    fun setStorage(storage: String): ComputerBuilder
    fun setDedicatedGPU(dedicatedGpu: String): ComputerBuilder
}

class ComputerBuilderImpl : ComputerBuilder {
    private lateinit var cpu: String
    private lateinit var ram: String
    private lateinit var storage: String
    private var dedicatedGpu: String? = null

    override fun setCPU(cpu: String): ComputerBuilderImpl {
        this.cpu = cpu
        return this
    }

    override fun setRAM(ram: String): ComputerBuilderImpl {
        this.ram = ram
        return this
    }

    override fun setStorage(storage: String): ComputerBuilderImpl {
        this.storage = storage
        return this
    }

    override fun setDedicatedGPU(dedicatedGpu: String): ComputerBuilderImpl {
        this.dedicatedGpu = dedicatedGpu
        return this
    }

    fun build(): Computer {
        return Computer(
            cpu = cpu,
            ram = ram,
            storage = storage,
            dedicatedGpu = dedicatedGpu
        )
    }
}
