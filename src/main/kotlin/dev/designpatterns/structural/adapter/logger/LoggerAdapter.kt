package dev.designpatterns.structural.adapter.logger

import io.github.oshai.kotlinlogging.KotlinLogging

interface LoggerAdapter {
    fun writeLog(vararg args: Any)
    fun writeWarning(vararg args: Any)
    fun writeError(vararg args: Any)
    fun writeDebug(vararg args: Any)
}

class LoggerAdapterImpl(file: String) : LoggerAdapter {
    private val logger = KotlinLogging.logger(file)

    override fun writeLog(vararg args: Any) {
        logger.info { args.joinToString() }
    }

    override fun writeWarning(vararg args: Any) {
        logger.warn { args.joinToString() }
    }

    override fun writeError(vararg args: Any) {
        logger.error { args.joinToString() }
    }

    override fun writeDebug(vararg args: Any) {
        logger.debug { args.joinToString() }
    }
}
