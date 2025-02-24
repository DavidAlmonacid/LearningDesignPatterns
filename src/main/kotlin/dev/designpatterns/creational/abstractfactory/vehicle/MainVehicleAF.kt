package dev.designpatterns.creational.abstractfactory.vehicle

fun main() {
    println("\n -- Abstract Factory Pattern - Challenge!!! -- \n")

    println("* Creating an Electric Vehicle:")
    createVehicle(ElectricVehicleFactory())

    println("\n* Creating a Gas Vehicle:")
    createVehicle(GasVehicleFactory())
}

fun createVehicle(factory: VehicleFactory) {
    val vehicle = factory.createVehicle()
    val engine = factory.createEngine()

    vehicle.assemble()
    engine.start()
}
