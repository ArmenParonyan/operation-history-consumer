package ru.pdn.sfedu.operationhistoryconsumer.dto

import java.math.BigDecimal
import java.util.*

class DtoOperation (
        val fromAccount: String? = null,
        val toAccount: String? = null,
        val amount: BigDecimal? = null,
        val currency: String? = null,
        val date: Date? = null
) {
    override fun toString(): String {
        return "DtoOperation(fromAccount=$fromAccount, toAccount=$toAccount, amount=$amount, currency=$currency, date=$date)"
    }
}