package com.example.kafkabackend.config

import com.example.kafkabackend.domain.entities.BankAccount
import com.example.kafkabackend.domain.entities.Transaction
import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig {

    // Configuración de la URL de los servidores de Kafka
    private val KAFKA_SERVERS = "localhost:9092"

    // Configuración de los esquemas Avro
    private val SCHEMA_REGISTRY_URL = "http://localhost:8081"

    @Bean
    fun bankAccountProducerFactory(): ProducerFactory<String, BankAccount> {
        val configs = mutableMapOf<String, Any>()
        configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = KAFKA_SERVERS
        configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = KafkaAvroSerializer::class.java
        configs["schema.registry.url"] = SCHEMA_REGISTRY_URL
        return DefaultKafkaProducerFactory(configs)
    }

    @Bean
    fun bankAccountKafkaTemplate(): KafkaTemplate<String, BankAccount> {
        return KafkaTemplate(bankAccountProducerFactory())
    }

    @Bean
    fun transactionProducerFactory(): ProducerFactory<String, Transaction> {
        val configs = mutableMapOf<String, Any>()
        configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = KAFKA_SERVERS
        configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = KafkaAvroSerializer::class.java
        configs["schema.registry.url"] = SCHEMA_REGISTRY_URL
        return DefaultKafkaProducerFactory(configs)
    }

    @Bean
    fun transactionKafkaTemplate(): KafkaTemplate<String, Transaction> {
        return KafkaTemplate(transactionProducerFactory())
    }
}
