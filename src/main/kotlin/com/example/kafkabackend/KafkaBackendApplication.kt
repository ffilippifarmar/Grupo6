package com.example.kafkabackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaBackendApplication

fun main(args: Array<String>) {
    runApplication<KafkaBackendApplication>(*args)
}
