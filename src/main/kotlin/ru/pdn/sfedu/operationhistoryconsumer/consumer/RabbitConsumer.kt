package ru.pdn.sfedu.operationhistoryconsumer.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service
import ru.pdn.sfedu.operationhistoryconsumer.config.OPERATION
import ru.pdn.sfedu.operationhistoryconsumer.dto.DtoOperation
import ru.pdn.sfedu.operationhistoryconsumer.model.Client
import ru.pdn.sfedu.operationhistoryconsumer.repository.ClientRepository
import ru.pdn.sfedu.operationhistoryconsumer.repository.OperationRepository
import ru.pdn.sfedu.operationhistoryconsumer.toOperation


@Service
class RabbitConsumer(
        val operationRepository: OperationRepository,
        val clientRepository: ClientRepository,
        val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = [OPERATION])
    fun receiveOperations(operationDto: DtoOperation){
        val client = Client().apply {
            name = "Name"
            secondName = "SecondName"
            age = 20
        }
        clientRepository.save(client)
        val operation = operationDto.toOperation()
        operation.client = client
        operationRepository.save(operation)
        println("Опрация сохранена в базу данных")
    }

}