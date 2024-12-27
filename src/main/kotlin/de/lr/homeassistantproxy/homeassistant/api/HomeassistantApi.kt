package de.lr.homeassistantproxy.homeassistant.api

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.time.OffsetDateTime

interface HomeassistantApi {
    @GetMapping("/api/states/{entityId}")
    fun getEntityState(
        @PathVariable entityId: String,
    ): HomeAssistantEntityState

    @PostMapping(
        "/api/services/{domain}/{service}",
        produces = ["application/json"],
        consumes = ["application/json"],
    )
    fun executeAction(
        @PathVariable domain: String,
        @PathVariable service: String,
        @RequestBody(required = false) serviceData: Map<String, Any>?,
    )
}

data class HomeAssistantEntityState(
    @JsonProperty("attributes")
    val attributes: Map<String, String>,
    @JsonProperty("entity_id")
    val entityId: String,
    @JsonProperty("last_changed")
    val lastChanged: OffsetDateTime,
    @JsonProperty("last_updated")
    val lastUpdated: OffsetDateTime,
    @JsonProperty("state")
    val state: String,
)
