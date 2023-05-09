package com.example.kafkabackend.services

import com.example.kafkabackend.domain.entities.BankAccount
import com.example.kafkabackend.domain.entities.Transaction
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class EventService(private val bankAccountKafkaTemplate: KafkaTemplate<String, BankAccount>,
                   private val transactionKafkaTemplate: KafkaTemplate<String, Transaction>) {

    fun sendBankAccountEvent(bankAccount: BankAccount) {
        bankAccountKafkaTemplate.send("bank_account_topic", bankAccount.accountNumber, bankAccount)
    }

    fun sendTransactionEvent(transaction: Transaction) {
        transactionKafkaTemplate.send("transaction_topic", transaction.transactionId.toString(), transaction)
    }
}
