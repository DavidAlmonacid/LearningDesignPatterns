package dev.designpatterns.creational.factorymethod.report

fun main() {
    println("\n -- Factory Method Pattern - Challenge!!! -- \n")

    print(
        """What kind of report do you want?
1. Sales
2. Inventory
3. Accounting

-> """
    )

    val userInput = readlnOrNull()?.trim()?.lowercase()
    val reportFactory = createReportFromInput(userInput)
    reportFactory.generateReport()
}

fun createReportFromInput(reportType: String?): ReportFactory {
    return when (reportType) {
        "1", "sales" -> SalesReportFactory()
        "2", "inventory" -> InventoryReportFactory()
        "3", "accounting" -> AccountingReportFactory()
        else -> {
            println("Invalid report type.")
            throw IllegalArgumentException("Invalid report type.")
        }
    }
}
