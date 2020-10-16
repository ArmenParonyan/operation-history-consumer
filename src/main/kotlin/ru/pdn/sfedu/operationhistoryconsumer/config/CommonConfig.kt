package ru.pdn.sfedu.operationhistoryconsumer.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CommonConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
    }
}