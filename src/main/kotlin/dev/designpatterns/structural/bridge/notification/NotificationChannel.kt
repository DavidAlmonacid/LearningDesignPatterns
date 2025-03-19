package dev.designpatterns.structural.bridge.notification

interface NotificationChannel {
    fun send(message: String)
}

class EmailChannel : NotificationChannel {

    override fun send(message: String) {
        println("Sending Email: $message")
    }
}

class SMSChannel : NotificationChannel {

    override fun send(message: String) {
        println("Sending SMS: $message")
    }
}

class PushNotificationChannel : NotificationChannel {

    override fun send(message: String) {
        println("Sending Push Notification: $message")
    }
}
