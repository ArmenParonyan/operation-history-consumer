package ru.pdn.sfedu.operationhistoryconsumer.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service
import ru.pdn.sfedu.operationhistoryconsumer.config.OPERATION
import ru.pdn.sfedu.operationhistoryconsumer.dto.DtoOperation
import ru.pdn.sfedu.operationhistoryconsumer.model.OperationsRepo
import java.nio.charset.Charset

@Service
class RabbitConsumer(
        val operationsRepo: OperationsRepo,
        val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = [OPERATION])
    fun receiveOperations(message: Message){
        val content = String(message.body, Charset.forName("UTF-8"))
        val operationDto = objectMapper.readValue(content, DtoOperation::class.java)
        println(operationDto)

    }

}