package com.example.ktl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class KtlApplication

fun main(args: Array<String>) {
    runApplication<KtlApplication>(*args)
}
