package ru.pdn.sfedu.operationhistoryconsumer.model

import javax.persistence.*

@Entity
@Table(name = "client")
class Client (
        @Column(name = "name")
        var name: String? = null,
        @Column(name = "secondName")
        var secondName: String? = null,
        @Column(name = "age")
        var age: Int? = null,
        @OneToMany(mappedBy = "client", cascade = [CascadeType.ALL], orphanRemoval = true)
        var operations: List<Operation> = arrayListOf()
): Domain(){
        override fun toString(): String {
                return "Client(name=$name, secondName=$secondName, age=$age, operations=$operations)"
        }
}