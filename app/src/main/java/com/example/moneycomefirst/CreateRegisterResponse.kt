package com.example.moneycomefirst

data class CreateRegisterResponse(
    val email: String,
    val nomor: Int,
    val response: String,
    val token: String,
    val username: String
)