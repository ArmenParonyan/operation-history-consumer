package ru.pdn.sfedu.operationhistoryconsumer.model

import org.springframework.data.jpa.repository.JpaRepository

interface OperationsRepo : JpaRepository<Operation, Long> {
    fun findByFromAccount(fromAccount: String): List<Operation>
    fun findByFromAccountAndToAccount(fromAccount: String, toAccount: String): List<Operation>
}