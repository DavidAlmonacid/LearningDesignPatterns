package dev.designpatterns.structural.bridge.notification

abstract class Notification(var channel: NotificationChannel) {

    abstract fun notify(message: String)
}

class AlertNotification(channel: NotificationChannel) : Notification(channel) {

    override fun notify(message: String) {
        println("Alert Notification:")
        channel.send(message)
        println()
    }
}

class RemainderNotification(channel: NotificationChannel) : Notification(channel) {

    override fun notify(message: String) {
        println("Remainder Notification:")
        channel.send(message)
        println()
    }
}

class PushNotification(channel: NotificationChannel) : Notification(channel) {

    override fun notify(message: String) {
        println("Push Notification:")
        channel.send(message)
        println()
    }
}
