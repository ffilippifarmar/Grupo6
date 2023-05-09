package com.example.kafkabackend.domain.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "transactions")
data class Transaction(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    open var transactionId: Long,

    @Column(name = "account_number", length = 50, nullable = false)
    open var accountNumber: String,

    @Column(name = "transaction_type", length = 50, nullable = false)
    open var transactionType: String,

    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    open var amount: BigDecimal,

    @Column(name = "currency", length = 10, nullable = false)
    open var currency: String,

    @Column(name = "transaction_date", nullable = false)
    open var transactionDate: Date,

    @Column(name = "description", length = 200, nullable = false)
    open var description: String
)
