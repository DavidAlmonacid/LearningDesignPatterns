package dev.designpatterns.creational.builder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ComputerBuilderImplTest {
    @Test
    fun `test building a basic computer`() {
        val computer = ComputerBuilderImpl()
            .setCPU("Intel Core i5 12450H")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build()

        assertEquals("Intel Core i5 12450H", computer.cpu)
        assertEquals("16GB", computer.ram)
        assertEquals("512GB SSD", computer.storage)
        assertNull(computer.dedicatedGpu)
    }

    @Test
    fun `test building a gaming computer`() {
        val computer = ComputerBuilderImpl()
            .setCPU("Intel Core i7 12700K")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setDedicatedGPU("Nvidia RTX 3080")
            .build()

        assertEquals("Intel Core i7 12700K", computer.cpu)
        assertEquals("32GB", computer.ram)
        assertEquals("1TB SSD", computer.storage)
        assertEquals("Nvidia RTX 3080", computer.dedicatedGpu)
    }
}
