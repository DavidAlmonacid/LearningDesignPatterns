package dev.designpatterns.structural.adapter.logger

/*
! Patrón Adapter
Permite que objetos con interfaces incompatibles trabajen juntos, también
es muy util para utilizar librerías de terceros en nuestra aplicación, sin
depender directamente de ellas.

* Es útil cuando se quiere reutilizar una clase que no tiene la interfaz que
* necesitamos, o cuando queremos crear una capa de abstracción para una
* librería de terceros.

https://refactoring.guru/es/design-patterns/adapter
 */

// Third party library interface
import io.github.oshai.kotlinlogging.KLogger

// Custom interface
interface LoggerAdapter {
    fun writeLog(vararg args: Any)
    fun writeWarning(vararg args: Any)
    fun writeError(vararg args: Any)
    fun writeDebug(vararg args: Any)
}

// Adapting the third party library to use the custom interface
class LoggerAdapterImpl(private val logger: KLogger) : LoggerAdapter {

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
