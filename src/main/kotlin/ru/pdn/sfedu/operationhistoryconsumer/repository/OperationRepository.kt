package ru.pdn.sfedu.operationhistoryconsumer.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.pdn.sfedu.operationhistoryconsumer.model.Operation

interface OperationsRepository : JpaRepository<Operation, Long> {
    fun findByFromAccount(fromAccount: String): List<Operation>
    fun findByFromAccountAndToAccount(fromAccount: String, toAccount: String): List<Operation>
}