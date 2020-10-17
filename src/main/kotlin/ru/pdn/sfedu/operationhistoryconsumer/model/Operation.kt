package ru.pdn.sfedu.operationhistoryconsumer.model

import ru.pdn.sfedu.operationhistoryconsumer.DateAdapter
import java.math.BigDecimal
import java.util.*
import javax.persistence.*
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@Entity
@Table(name = "operations")
class Operation (
        @Column(name = "from_account")
        val fromAccount: String? = null,
        @Column(name = "to_account")
        val toAccount: String? = null,
        @Column(name = "amount")
        val amount: BigDecimal? = null,
        @Column(name = "currency")
        val currency: String? = null,
        @Column(name = "date")
        val date: Date? = null,
        @Column(name = "doc_id")
        val docId: Long? = null,
        @ManyToOne
        @JoinColumn(name = "clientId")
        var client: Client? = null
): Domain() {
    override fun toString(): String {
        return "Operation(amount=$amount, date=$date)"
    }
}