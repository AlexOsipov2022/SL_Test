package utils

import config.Config
import org.yaml.snakeyaml.Yaml
import java.io.InputStream

object ConfigLoader {
    fun loadConfig(): Config {
        val inputStream: InputStream = ConfigLoader::class.java.getResourceAsStream("/config/config.yaml")
            ?: throw IllegalArgumentException("Файл config.yaml не найден")

        val yaml = Yaml()
        val data: Map<String, String> = yaml.load(inputStream) // Загружаем YAML как Map

        return Config(
            username = data["username"] ?: "",
            password = data["password"] ?: ""
        )
    }
}