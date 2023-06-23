package com.example.ktl.auth.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/status")
class StatusCheckController {

    @GetMapping
    fun serverStatusCheck(): ResponseEntity<String> {
        return ResponseEntity.ok("Server is running")
    }
}