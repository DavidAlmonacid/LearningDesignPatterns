package dev.designpatterns.structural.decorator.notification

/*
! Patrón decorador
Es un patrón de diseño estructural que permite añadir funcionalidades a
objetos, colocando estos objetos dentro de objetos encapsuladores especiales
que contienen estas funcionalidades.

¡Importante!:
No confundirlo con los decoradores de TypeScript que son anotaciones.

* Es útil cuando necesitas añadir funcionalidades a objetos
* de manera dinámica y flexible.

https://refactoring.guru/es/design-patterns/decorator
 */

interface Notification {
    fun send(message: String)
}

class BasicNotification : Notification {

    override fun send(message: String) {
        println("Sending basic notification: $message")
    }

}

abstract class NotificationDecorator(private val notification: Notification) : Notification {

    override fun send(message: String) {
        notification.send(message)
    }

}

class EmailDecorator(notification: Notification) : NotificationDecorator(notification) {

    private fun sendEmail(message: String) {
        println("Sending notification via Email: $message")
    }

    override fun send(message: String) {
        super.send(message)
        sendEmail(message)
    }

}

class SMSDecorator(notification: Notification) : NotificationDecorator(notification) {

    private fun sendSMS(message: String) {
        println("Sending notification via SMS: $message")
    }

    override fun send(message: String) {
        super.send(message)
        sendSMS(message)
    }

}
