package de.lr.homeassistantproxy.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "homeassistant")
data class HomeassistantConfiguration(
    val host: String,
    val apiKey: String,
    val shares: List<Share>,
)

data class Share(
    val name: String,
    val apiKey: String,
    val allowedEntities: List<String>,
)
