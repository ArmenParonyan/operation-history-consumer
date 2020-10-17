package ru.pdn.sfedu.operationhistoryconsumer.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory

const val OPERATION = "operation"

@Configuration
class AmqpConfig {
    @Bean
    fun rabbitListenerContainerFactory(connectionFactory: ConnectionFactory) = SimpleRabbitListenerContainerFactory().apply {
        setConnectionFactory(connectionFactory)
        setMessageConverter(Jackson2JsonMessageConverter())
    }
}
