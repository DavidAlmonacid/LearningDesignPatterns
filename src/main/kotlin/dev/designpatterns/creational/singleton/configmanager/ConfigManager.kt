package dev.designpatterns.creational.singleton.configmanager

object ConfigManager {
    private val config: MutableMap<String, String> = mutableMapOf()

    fun setConfig(key: String, value: String) {
        config[key] = value
    }

    fun getConfig(key: String): String? {
        return config[key]
    }

    fun getAllConfig(): Map<String, String> {
        return config.toMap()
    }
}
