package dev.designpatterns.structural.decorator.notification

fun main() {
    println("\n -- Decorator Pattern -- \n")

    var notification: Notification = BasicNotification()

    // Decorating the basic notification
    notification = EmailDecorator(notification)
    notification = SMSDecorator(notification)

    // Calling the send method for sending the notification depending on our decorators
    notification.send("¡¡¡Enviando notificación!!!")
}
