package com.com.eliezer.freyardaya.markart.io.response

data class LoginRequest(

    val email: String,
    val password: String
)

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String
)

data class RegisterResponse(
    val message: String
)

data class UserResponse(
    val name: String,
    val email: String
)
