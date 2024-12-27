package de.lr.homeassistantproxy.configuration

import feign.Contract
import feign.RequestInterceptor
import feign.RequestTemplate
import feign.codec.Decoder
import feign.codec.Encoder
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.support.SpringMvcContract
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HomeassistantFeignConfig(
    @Value("\${homeassistant.apiKey}")
    val apiKey: String,
) {
    @Bean
    fun requestInterceptor(): RequestInterceptor =
        RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header("Authorization", "Bearer $apiKey")
        }

    @Bean
    fun contract(): Contract = SpringMvcContract()

    @Bean
    fun decoder(): Decoder = JacksonDecoder(customObjectMapper())

    @Bean
    fun encoder(): Encoder = JacksonEncoder(customObjectMapper())
}
