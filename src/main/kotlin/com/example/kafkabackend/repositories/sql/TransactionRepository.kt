package com.example.kafkabackend.repositories.sql

import com.example.kafkabackend.domain.entities.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long>
