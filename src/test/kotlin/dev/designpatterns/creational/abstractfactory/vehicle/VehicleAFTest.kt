package dev.designpatterns.creational.abstractfactory.vehicle

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class VehicleAFTest {
    @Test
    fun `test ElectricVehicleFactory`() {
        val factory = ElectricVehicleFactory()
        val engine = factory.createEngine()
        val vehicle = factory.createVehicle()

        assertTrue(engine is ElectricEngine)
        assertTrue(vehicle is ElectricCar)
    }

    @Test
    fun `test GasVehicleFactory`() {
        val factory = GasVehicleFactory()
        val engine = factory.createEngine()
        val vehicle = factory.createVehicle()

        assertTrue(engine is GasEngine)
        assertTrue(vehicle is GasCar)
    }
}
