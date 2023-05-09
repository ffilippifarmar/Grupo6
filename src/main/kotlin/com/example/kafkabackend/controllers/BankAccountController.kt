package com.example.kafkabackend.controllers

import com.example.kafkabackend.domain.entities.BankAccount
import com.example.kafkabackend.services.BankAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/bank-accounts")
class BankAccountController {

    @Autowired
    lateinit var bankAccountService: BankAccountService

    @GetMapping("/{accountNumber}")
    fun getBankAccount(@PathVariable accountNumber: String): BankAccount? {
        return bankAccountService.getBankAccount(accountNumber)
    }

    @PostMapping
    fun createBankAccount(@RequestBody bankAccount: BankAccount): BankAccount {
        return bankAccountService.createBankAccount(bankAccount)
    }

    @PutMapping("/{accountNumber}")
    fun updateBankAccount(
        @PathVariable accountNumber: String,
        @RequestBody updatedBankAccount: BankAccount
    ): BankAccount? {
        return bankAccountService.updateBankAccount(accountNumber, updatedBankAccount)
    }

    @DeleteMapping("/{accountNumber}")
    fun deleteBankAccount(@PathVariable accountNumber: String) {
        bankAccountService.deleteBankAccount(accountNumber)
    }
}
