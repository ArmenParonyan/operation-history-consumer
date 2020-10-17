package ru.pdn.sfedu.operationhistoryconsumer.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.pdn.sfedu.operationhistoryconsumer.model.Client

interface ClientRepository: JpaRepository<Client, Long>{
}