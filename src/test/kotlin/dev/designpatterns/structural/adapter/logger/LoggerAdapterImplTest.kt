package dev.designpatterns.structural.adapter.logger

import io.github.oshai.kotlinlogging.KLogger
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.verify
import kotlin.test.assertEquals

class LoggerAdapterImplTest {

    private lateinit var loggerAdapter: LoggerAdapterImpl
    private val mockLogger: KLogger = mock()

    @BeforeEach
    fun setUp() {
        loggerAdapter = LoggerAdapterImpl(mockLogger)
    }

    @Test
    fun `test writeLog`() {
        loggerAdapter.writeLog("Test log message")

        val captor = argumentCaptor<() -> Any?>()
        verify(mockLogger).info(captor.capture())

        val capturedMessage = captor.firstValue.invoke() as String

        assertEquals("Test log message", capturedMessage)
    }

    @Test
    fun `test writeWarning with complex message`() {
        loggerAdapter.writeWarning("Set", setOf("junior", "junior", "pancho", "frida"))

        val captor = argumentCaptor<() -> Any?>()
        verify(mockLogger).warn(captor.capture())

        val capturedMessage = captor.firstValue.invoke() as String
        val expectedMessage = "Set, [junior, pancho, frida]"

        assertEquals(expectedMessage, capturedMessage)
    }

    @Test
    fun `test writeError with multiple arguments`() {
        loggerAdapter.writeError("Error occurred", "Details", listOf(1, 2, 3))

        val captor = argumentCaptor<() -> Any?>()
        verify(mockLogger).error(captor.capture())

        val capturedMessage = captor.firstValue.invoke() as String
        val expectedMessage = "Error occurred, Details, [1, 2, 3]"

        assertEquals(expectedMessage, capturedMessage)
    }

    @Test
    fun `test writeDebug with mixed data types`() {
        loggerAdapter.writeDebug("Debug info", 42, mapOf("key" to "value"))

        val captor = argumentCaptor<() -> Any?>()
        verify(mockLogger).debug(captor.capture())

        val capturedMessage = captor.firstValue.invoke() as String
        val expectedMessage = "Debug info, 42, {key=value}"

        assertEquals(expectedMessage, capturedMessage)
    }

}
