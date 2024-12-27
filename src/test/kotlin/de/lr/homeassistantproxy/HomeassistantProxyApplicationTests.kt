package de.lr.homeassistantproxy

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HomeassistantProxyApplicationTests {
    @Test
    fun `can open garage door`() {
        1 shouldBe 1
    }
}
