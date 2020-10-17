package ru.pdn.sfedu.operationhistoryconsumer.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service
import ru.pdn.sfedu.operationhistoryconsumer.config.OPERATION
import ru.pdn.sfedu.operationhistoryconsumer.dto.DtoOperation
import ru.pdn.sfedu.operationhistoryconsumer.model.Client
import ru.pdn.sfedu.operationhistoryconsumer.repository.ClientRepository
import ru.pdn.sfedu.operationhistoryconsumer.repository.OperationsRepository
import ru.pdn.sfedu.operationhistoryconsumer.toOperation
import java.nio.charset.Charset


@Service
class RabbitConsumer(
        val operationsRepository: OperationsRepository,
        val clientRepository: ClientRepository,
        val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = [OPERATION])
    fun receiveOperations(operationDto: DtoOperation){
//        val content = String(message.body, Charset.forName("UTF-8"))
//        val operationDto = objectMapper.readValue(content, DtoOperation::class.java)
        val client = Client().apply {
            name = "Name"
            secondName = "SecondName"
            age = 20
        }
        clientRepository.save(client)
        val operation = operationDto.toOperation()


        operation.client = client
        operationsRepository.save(operation)
        println("Опрация сохранена в базу данных")
    }

}