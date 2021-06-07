package com.example.moneycomefirst

import com.google.gson.annotations.SerializedName

data class WalletResponse(
    val id: String,
    val name: String,
    @SerializedName("saldo")
    val saldo_now: String
)