package com.example.moneycomefirst

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
    private const val BASE_URL = "https://mcf-iai.herokuapp.com/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}