package dev.designpatterns.structural.decorator.notification

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class NotificationDecoratorTest {

    private val originalOut: PrintStream = System.out
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `test BasicNotification prints basic message`() {
        val notification: Notification = BasicNotification()
        val testMessage = "Hello, world!"
        notification.send(testMessage)

        val output = outputStream.toString().trim()
        assertTrue(output.contains("Sending basic notification: $testMessage"))
    }

    @Test
    fun `test EmailDecorator prints both basic and email messages`() {
        val basicNotification: Notification = BasicNotification()
        val notification: Notification = EmailDecorator(basicNotification)
        val testMessage = "Email Test"
        notification.send(testMessage)

        val output = outputStream.toString().trim()
        // Check both messages are printed
        assertTrue(output.contains("Sending basic notification: $testMessage"))
        assertTrue(output.contains("Sending notification via Email: $testMessage"))
    }

    @Test
    fun `test SMSDecorator prints both basic and SMS messages`() {
        val basicNotification: Notification = BasicNotification()
        val notification: Notification = SMSDecorator(basicNotification)
        val testMessage = "SMS Test"
        notification.send(testMessage)

        val output = outputStream.toString().trim()
        // Check both messages are printed
        assertTrue(output.contains("Sending basic notification: $testMessage"))
        assertTrue(output.contains("Sending notification via SMS: $testMessage"))
    }

    @Test
    fun `test combined decorators print messages in order`() {
        var notification: Notification = BasicNotification()
        notification = EmailDecorator(notification)
        notification = SMSDecorator(notification)
        val testMessage = "Combined Test"
        notification.send(testMessage)

        val output = outputStream.toString().trim()
        // The output should contain basic, then email and SMS messages.
        assertTrue(output.contains("Sending basic notification: $testMessage"))
        assertTrue(output.contains("Sending notification via Email: $testMessage"))
        assertTrue(output.contains("Sending notification via SMS: $testMessage"))
    }

}
