package dev.designpatterns.structural.bridge.notification

fun main() {
    println("\n -- Bridge Pattern - Challenge!!! -- \n")

    // Crear una notificación de alerta usando el canal de correo electrónico
    val alert = AlertNotification(EmailChannel())
    alert.notify("Alerta de seguridad: Se ha detectado un acceso no autorizado.")

    // Cambiar el canal a SMS y volver a enviar la alerta
    alert.channel = SMSChannel()
    alert.notify("Alerta de seguridad: Se ha detectado un acceso no autorizado.")

    // Crear una notificación de recordatorio usando el canal de SMS
    val remainder = RemainderNotification(SMSChannel())
    remainder.notify("Recordatorio: Tu cita con el médico es mañana a las 7:00 a.m.")

    // Cambiar el canal de recordatorio a correo electrónico y enviar nuevamente
    remainder.channel = EmailChannel()
    remainder.notify("Recordatorio: Tu cita con el médico es mañana a las 7:00 a.m.")

    // Crear una notificación de push usando el canal de notificación push
    val push = PushNotification(PushNotificationChannel())
    push.notify("Nueva actualización disponible. Haz click para instalar.")
}
