package de.lr.homeassistantproxy.api

import de.lr.homeassistantproxy.configuration.HomeassistantConfiguration
import de.lr.homeassistantproxy.homeassistant.api.HomeAssistantEntityState
import de.lr.homeassistantproxy.homeassistant.client.HomeAssistantApiClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class StatesController(
    val homeassistantConfiguration: HomeassistantConfiguration,
    val homeAssistantApiClient: HomeAssistantApiClient,
) {
    @GetMapping("/entities/{domain}/{entityId}/state")
    suspend fun getEntityState(
        @PathVariable domain: String,
        @PathVariable entityId: String,
        @RequestHeader("X-Requester-Key", required = true) apiKey: String,
    ): ResponseEntity<HomeAssistantEntityState> {
        val share =
            homeassistantConfiguration.shares.find { it.apiKey == apiKey } ?: return ResponseEntity.status(403).build()

        if (share.allowedEntities.contains("$domain.$entityId").not()) {
            return ResponseEntity.status(403).build()
        }

        return ResponseEntity.ok(homeAssistantApiClient.getEntityState("$domain.$entityId"))
    }

    @PostMapping("/entities/{domain}/{entityId}/action/{service}")
    suspend fun executeAction(
        @PathVariable domain: String,
        @PathVariable entityId: String,
        @PathVariable service: String,
        @RequestHeader("X-Requester-Key", required = true) apiKey: String,
    ): ResponseEntity<Void> {
        val share =
            homeassistantConfiguration.shares.find { it.apiKey == apiKey } ?: return ResponseEntity.status(403).build()

        if (share.allowedEntities.contains("$domain.$entityId").not()) {
            return ResponseEntity.status(403).build()
        }

        homeAssistantApiClient
            .executeAction(domain, service, mapOf("entity_id" to "$domain.$entityId"))

        return ResponseEntity.ok().build()
    }
}
