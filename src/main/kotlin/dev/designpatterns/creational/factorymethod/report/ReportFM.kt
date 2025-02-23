package dev.designpatterns.creational.factorymethod.report

interface Report {
    fun generate()
}

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

abstract class ReportFactory {
    protected abstract fun createReport(): Report

    fun generateReport() {
        val report = createReport()
        report.generate()
    }
}

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
