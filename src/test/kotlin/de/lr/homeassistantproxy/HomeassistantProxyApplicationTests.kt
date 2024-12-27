package de.lr.homeassistantproxy

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeassistantProxyApplicationTests(
    val webTestClient: WebTestClient,
) {
    @Test
    fun `can open garage door`() {
    }
}
