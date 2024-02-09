package se.implementer.sportservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

    @Bean
    fun restClient(): RestClient.Builder {
        return RestClient
            .builder()
    }
}