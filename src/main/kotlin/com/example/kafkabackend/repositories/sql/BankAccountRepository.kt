package com.example.kafkabackend.repositories.sql

import com.example.kafkabackend.domain.entities.BankAccount
import org.springframework.data.repository.CrudRepository

interface BankAccountRepository : CrudRepository<BankAccount, String>
