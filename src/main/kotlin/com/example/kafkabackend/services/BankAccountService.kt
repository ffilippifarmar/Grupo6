package com.example.kafkabackend.services

import com.example.kafkabackend.domain.entities.BankAccount
import com.example.kafkabackend.repositories.sql.BankAccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class BankAccountService {

    @Autowired
    lateinit var bankAccountRepository: BankAccountRepository

    fun getBankAccount(accountNumber: String): BankAccount? {
        return bankAccountRepository.findById(accountNumber).orElse(null)
    }

    fun createBankAccount(bankAccount: BankAccount): BankAccount {
        return bankAccountRepository.save(bankAccount)
    }

    fun updateBankAccount(accountNumber: String, updatedBankAccount: BankAccount): BankAccount? {
        return bankAccountRepository.findById(accountNumber).map { existingAccount ->
            val updatedAccount = existingAccount.copy(
                accountHolder = updatedBankAccount.accountHolder,
                balance = updatedBankAccount.balance,
                currency = updatedBankAccount.currency,
                ownerName = updatedBankAccount.ownerName,
                ownerAddress = updatedBankAccount.ownerAddress,
                ownerPhoneNumber = updatedBankAccount.ownerPhoneNumber,
                accountType = updatedBankAccount.accountType,
                isOpen = updatedBankAccount.isOpen,
                lastTransactionDate = updatedBankAccount.lastTransactionDate
            )
            bankAccountRepository.save(updatedAccount)
        }.orElse(null)
    }

    fun deleteBankAccount(accountNumber: String) {
        bankAccountRepository.deleteById(accountNumber)
    }
}
