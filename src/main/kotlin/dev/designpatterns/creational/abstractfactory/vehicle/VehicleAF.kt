package dev.designpatterns.creational.abstractfactory.vehicle

/*
! Challenge:

1. Completar las Clases de Productos:
- ElectricCar debe implementar Vehicle y mostrar el mensaje "Ensamblando un auto eléctrico".
- GasCar debe implementar Vehicle y mostrar el mensaje "Ensamblando un auto de combustión".
- ElectricEngine debe implementar Engine y mostrar el mensaje "Arrancando motor eléctrico".
- GasEngine debe implementar Engine y mostrar el mensaje "Arrancando motor de combustión".

2. Completar las Clases de Fábricas:
- ElectricVehicleFactory debe crear un ElectricCar y un ElectricEngine.
- GasVehicleFactory debe crear un GasCar y un GasEngine.

3. Probar el Código:
- Ejecutar el código para asegurarse de que cada fábrica produce el tipo correcto de vehículo y motor.
 */

// 1. Interfaces de Vehicle y Engine

interface Vehicle {
    fun assemble()
}

interface Engine {
    fun start()
}

// 2. Clases Concretas de Productos

class ElectricCar : Vehicle {
    override fun assemble() = println("Ensamblando un auto eléctrico")
}

class GasCar : Vehicle {
    override fun assemble() = println("Ensamblando un auto de combustión")
}

class ElectricEngine : Engine {
    override fun start() = println("Arrancando motor eléctrico")
}

class GasEngine : Engine {
    override fun start() = println("Arrancando motor de combustión")
}

// 3. Interfaz de la Fábrica Abstracta

interface VehicleFactory {
    fun createVehicle(): Vehicle
    fun createEngine(): Engine
}

// 4. Clases Concretas de Fábricas

class ElectricVehicleFactory : VehicleFactory {
    override fun createVehicle(): Vehicle = ElectricCar()
    override fun createEngine(): Engine = ElectricEngine()
}

class GasVehicleFactory : VehicleFactory {
    override fun createVehicle(): Vehicle = GasCar()
    override fun createEngine(): Engine = GasEngine()
}
