package com.example.garapp.models

data class LoginResponse(
    val token: String,
    val user: User
)
