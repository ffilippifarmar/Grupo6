package com.example.kafkabackend.domain.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "bank_account")
data class BankAccount(
    @Id
    @Column(name = "account_number", length = 50)
    open var accountNumber: String,

    @Column(name = "account_holder", length = 100, nullable = false)
    open var accountHolder: String,

    @Column(name = "balance", precision = 10, scale = 2, nullable = false)
    open var balance: BigDecimal,

    @Column(name = "currency", length = 10, nullable = false)
    open var currency: String,

    @Column(name = "owner_name", length = 100, nullable = false)
    open var ownerName: String,

    @Column(name = "owner_address", length = 200, nullable = false)
    open var ownerAddress: String,

    @Column(name = "owner_phone_number", length = 20, nullable = false)
    open var ownerPhoneNumber: String,

    @Column(name = "account_type", length = 50, nullable = false)
    open var accountType: String,

    @Column(name = "is_open", nullable = false)
    open var isOpen: Boolean,

    @Column(name = "last_transaction_date")
    open var lastTransactionDate: Date?
)
