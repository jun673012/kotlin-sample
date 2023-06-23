package com.example.ktl.auth.service

import com.example.ktl.auth.domain.User
import com.example.ktl.auth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private var userRepository: UserRepository) {

    init {
        this.userRepository = userRepository
    }
    fun findOne(userId: String?): Optional<User> {
        return userRepository.findByUserid(userId)
    }

}