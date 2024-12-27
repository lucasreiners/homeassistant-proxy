package de.lr.homeassistantproxy

import de.lr.homeassistantproxy.configuration.HomeassistantConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableConfigurationProperties(
    HomeassistantConfiguration::class,
)
@EnableFeignClients
class HomeassistantProxyApplication

fun main(args: Array<String>) {
    runApplication<HomeassistantProxyApplication>(*args)
}
