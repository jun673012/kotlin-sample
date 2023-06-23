package com.example.ktl.auth.controller

import com.example.ktl.auth.dto.UserDto
import com.example.ktl.auth.service.RegisterUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthorizationController(private var registerUserService: RegisterUserService) {

    init {
        this.registerUserService = registerUserService
    }

    @PostMapping("/join")
    fun join(@RequestBody dto: UserDto): ResponseEntity<String> {
        try{
            registerUserService.join(dto.getUserId(), dto.getPassword())
            return ResponseEntity.ok("회원가입이 완료되었습니다.")
        } catch (e: IllegalStateException) {
            return ResponseEntity.badRequest().body(e.message)
        }
    }

}