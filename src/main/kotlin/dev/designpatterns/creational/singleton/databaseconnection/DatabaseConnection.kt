package dev.designpatterns.creational.singleton.databaseconnection

object DatabaseConnection {
    private var connected: Boolean = false

    fun connect() {
        println()

        if (!connected) {
            println("Connecting...")
            connected = true
            println("🟢 The database has been connected successfully!")
            return
        }

        println("The database is already connected!")
    }

    fun disconnect() {
        println()

        if (connected) {
            println("Disconnecting...")
            connected = false
            println("🔴 The database has been disconnected successfully!")
            return
        }

        println("The database is already disconnected!")
    }
}
