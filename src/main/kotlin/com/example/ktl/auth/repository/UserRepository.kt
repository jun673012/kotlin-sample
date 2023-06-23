package com.example.ktl.auth.repository

import com.example.ktl.auth.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long>{

    fun findByUserid(userId: String?): Optional<User>
}