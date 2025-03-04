package dev.designpatterns.structural.adapter.logger

interface LoggerAdapter {
    fun writeLog()
    fun writeWarning()
    fun writeError()
    fun writeDebug()
}

class LoggerAdapterImpl : LoggerAdapter {
    override fun writeLog() {
        TODO("Not yet implemented")
    }

    override fun writeWarning() {
        TODO("Not yet implemented")
    }

    override fun writeError() {
        TODO("Not yet implemented")
    }

    override fun writeDebug() {
        TODO("Not yet implemented")
    }
}
