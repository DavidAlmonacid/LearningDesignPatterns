package dev.designpatterns.creational.factorymethod.report

/*
 * Challenge:
 *
 * 1. Completar las clases SalesReport e InventoryReport para implementar
 * la interfaz Report, generando el contenido de cada reporte en el method generate.
 *
 * 2. Implementar las clases SalesReportFactory e InventoryReportFactory
 * para crear instancias de SalesReport e InventoryReport, respectivamente.
 *
 * 3. Probar el programa generando diferentes tipos de reportes usando
 * el prompt para seleccionar el tipo de reporte.
 */

// 1. Define the Report interface
interface Report {
    fun generate()
}

// 2. Concrete classes ↓↓↓

class SalesReport : Report {
    override fun generate() {
        println("Generating sales report...")
    }
}

class InventoryReport : Report {
    override fun generate() {
        println("Generating inventory report...")
    }
}

class AccountingReport : Report {
    override fun generate() {
        println("Generating accounting report...")
    }
}

// 3. Base class ReportFactory with the Factory Method
abstract class ReportFactory {
    protected abstract fun createReport(): Report

    fun generateReport() {
        val report = createReport()
        report.generate()
    }
}

// 4. Concrete classes of Report Factories ↓↓↓

class SalesReportFactory : ReportFactory() {
    override fun createReport(): Report {
        return SalesReport()
    }
}

class InventoryReportFactory : ReportFactory() {
    override fun createReport(): Report {
        return InventoryReport()
    }
}

class AccountingReportFactory : ReportFactory() {
    override fun createReport(): Report {
        return AccountingReport()
    }
}
