package com.example.ktl.auth.config


import com.example.ktl.auth.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class MyUserDetailsService(userService: UserService) : UserDetailsService {
    private val userService: UserService

    init {
        this.userService = userService
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(insertedUserId: String?): UserDetails {
        val findOne: Optional<com.example.ktl.auth.domain.User> = userService.findOne(insertedUserId)
        val user: com.example.ktl.auth.domain.User = findOne.orElseThrow { UsernameNotFoundException("없는 회원입니다 ㅠ") }
        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getUserId())
            .password(user.getPassword())
            .roles(user.getRole())
            .build()
    }
}