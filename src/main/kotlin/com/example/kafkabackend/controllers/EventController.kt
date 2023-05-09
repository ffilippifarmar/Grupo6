package com.example.kafkabackend.controllers

import com.example.kafkabackend.domain.entities.BankAccount
import com.example.kafkabackend.domain.entities.Transaction
import com.example.kafkabackend.services.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/events")
class EventController{

    @Autowired
    lateinit var  eventService: EventService

    @PostMapping("/bank-account")
    fun createBankAccountEvent(@RequestBody bankAccount: BankAccount) {
        eventService.sendBankAccountEvent(bankAccount)
    }

    @PostMapping("/transaction")
    fun createTransactionEvent(@RequestBody transaction: Transaction) {
        eventService.sendTransactionEvent(transaction)
    }
}
