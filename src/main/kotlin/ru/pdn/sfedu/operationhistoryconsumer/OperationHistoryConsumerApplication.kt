package ru.pdn.sfedu.operationhistoryconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OperationHistoryConsumerApplication {
}

fun main(args: Array<String>) {
    runApplication<OperationHistoryConsumerApplication>(*args)
}
