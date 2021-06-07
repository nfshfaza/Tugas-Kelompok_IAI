package com.example.moneycomefirst

import com.google.gson.annotations.SerializedName

data class HistoryResponse(
    @SerializedName("id")
    val transactions_id: Int,
    @SerializedName("jenis")
    val transactions_type: String,
    val timestamp: String,
    val value: String,
    val wallet: WalletResponse,
    val wallet_id: String
)