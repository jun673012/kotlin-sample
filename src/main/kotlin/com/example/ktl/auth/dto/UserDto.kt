package com.example.ktl.auth.dto

class UserDto(
    userId: String,
    password: String,
) {
    val userId: String = userId
    val password: String = password

    fun getUserId(): String {
        return userId
    }

    fun getPassword(): String {
        return password
    }


}