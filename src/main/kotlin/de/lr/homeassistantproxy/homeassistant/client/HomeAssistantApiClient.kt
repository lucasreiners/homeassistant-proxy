package de.lr.homeassistantproxy.homeassistant.client

import de.lr.homeassistantproxy.configuration.HomeassistantFeignConfig
import de.lr.homeassistantproxy.homeassistant.api.HomeassistantApi
import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "homeassistant", url = "\${homeassistant.host}", configuration = [HomeassistantFeignConfig::class])
interface HomeAssistantApiClient : HomeassistantApi
