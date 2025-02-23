package dev.designpatterns.creational.factorymethod.report

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ReportFactoryTest {
    // Helper function to capture system output.
    private fun captureOutput(block: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        val oldOut = System.out

        System.setOut(PrintStream(outputStream))
        block()
        System.setOut(oldOut)

        return outputStream.toString().trim()
    }

    @Test
    fun `test SalesReportFactory shows expected message`() {
        val output = captureOutput { SalesReportFactory().generateReport() }
        assertTrue(output.contains("Generating sales report..."))
    }

    @Test
    fun `test InventoryReportFactory shows expected message`() {
        val output = captureOutput { InventoryReportFactory().generateReport() }
        assertTrue(output.contains("Generating inventory report..."))
    }

    @Test
    fun `test AccountingReportFactory shows expected message`() {
        val output = captureOutput { AccountingReportFactory().generateReport() }
        assertTrue(output.contains("Generating accounting report..."))
    }
}
