package com.example.ktl.auth.domain

import jakarta.persistence.*
import org.springframework.security.crypto.password.PasswordEncoder

@Entity
open class User(
    userid: String,
    password: String,
    roles: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var userid: String = userid

    @Column(nullable = false)
    var password: String = password

    @Column(nullable = false)
    var roles: String = roles

    companion object {
        fun createUser(userid: String, password: String, passwordEncoder: PasswordEncoder): User {
            return User(userid, passwordEncoder.encode(password), "USER")
        }
    }


    fun getId(): Long? {
        return id
    }

    @JvmName("getUserId")
    fun getUserId(): String {
        return userid
    }

    @JvmName("getPasswordValue")
    fun getPassword(): String {
        return password
    }

    fun getRole(): String {
        return roles
    }

}