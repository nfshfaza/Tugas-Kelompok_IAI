package com.example.moneycomefirst

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("id")
    var id: Int
)