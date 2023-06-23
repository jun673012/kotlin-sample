package com.example.ktl.auth.service

import com.example.ktl.auth.domain.User
import com.example.ktl.auth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class RegisterUserService @Autowired constructor(
     passwordEncoder: PasswordEncoder,
     userRepository: UserRepository
) {
    private val passwordEncoder: PasswordEncoder
    private val userRepository: UserRepository

    init {
        this.passwordEncoder = passwordEncoder
        this.userRepository = userRepository
    }

    fun join(userid: String, password: String): Long? {
        val user: User = User.createUser(userid, password, passwordEncoder)
        validateDuplicateUser(user)
        userRepository.save(user)
        return user.getId()
    }

    private fun validateDuplicateUser(user: User) {
        userRepository.findByUserid(user.getUserId())
            .ifPresent { throw IllegalStateException("이미 존재하는 회원입니다.") }
    }
}
