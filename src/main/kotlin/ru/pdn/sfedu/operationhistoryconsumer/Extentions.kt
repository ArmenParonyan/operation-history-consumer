package ru.pdn.sfedu.operationhistoryconsumer

import ru.pdn.sfedu.operationhistoryconsumer.dto.DtoOperation
import ru.pdn.sfedu.operationhistoryconsumer.model.Operation


fun DtoOperation.toOperation(): Operation {
    return Operation(
            fromAccount = this.fromAccount,
            toAccount = this.toAccount,
            amount = this.amount,
            currency = this.currency,
            date =  this.date
    )
}