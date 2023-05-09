package com.example.kafkabackend.controllers

import com.example.kafkabackend.domain.entities.Transaction
import com.example.kafkabackend.services.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transactions")
class TransactionController(@Autowired private val transactionService: TransactionService) {

    @GetMapping("/{transactionId}")
    fun getTransaction(@PathVariable transactionId: Long): Transaction? {
        return transactionService.getTransaction(transactionId)
    }

    @PostMapping
    fun createTransaction(@RequestBody transaction: Transaction): Transaction {
        return transactionService.createTransaction(transaction)
    }

    @PutMapping("/{transactionId}")
    fun updateTransaction(
        @PathVariable transactionId: Long,
        @RequestBody updatedTransaction: Transaction
    ): Transaction? {
        return transactionService.updateTransaction(transactionId, updatedTransaction)
    }

    @DeleteMapping("/{transactionId}")
    fun deleteTransaction(@PathVariable transactionId: Long) {
        transactionService.deleteTransaction(transactionId)
    }
}
