package com.example.kafkabackend.services

import com.example.kafkabackend.domain.entities.Transaction
import com.example.kafkabackend.repositories.sql.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService {

    @Autowired
    lateinit var transactionRepository: TransactionRepository

    fun getTransaction(transactionId: Long): Transaction? {
        return transactionRepository.findById(transactionId).orElse(null)
    }

    fun createTransaction(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction)
    }

    fun updateTransaction(transactionId: Long, updatedTransaction: Transaction): Transaction? {
        return transactionRepository.findById(transactionId).map { existingTransaction ->
            val updatedTransaction = existingTransaction.copy(
                accountNumber = updatedTransaction.accountNumber,
                transactionType = updatedTransaction.transactionType,
                amount = updatedTransaction.amount,
                currency = updatedTransaction.currency,
                transactionDate = updatedTransaction.transactionDate,
                description = updatedTransaction.description
            )
            transactionRepository.save(updatedTransaction)
        }.orElse(null)
    }

    fun deleteTransaction(transactionId: Long) {
        transactionRepository.deleteById(transactionId)
    }
}
