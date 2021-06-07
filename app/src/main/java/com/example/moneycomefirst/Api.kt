package com.example.moneycomefirst

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("transactions/history/")
    fun getHistory(): Call<ArrayList<HistoryResponse>>

    @FormUrlEncoded
    @POST("account/register/")
    fun createRegister(
        @Field("response") response: String,
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("nomor") nomor: Int
    ): Call<CreateRegisterResponse>

    @FormUrlEncoded
    @POST("account/login")
    fun createLogin(
        @Field("token") token: String
    ): Call<CreateLoginResponse>

    @FormUrlEncoded
    @POST("transactions/create-wallet/")
    fun createWallet(
        @Field("response") response: String
    ): Call<CreateWalletResponse>

    @FormUrlEncoded
    @POST("transactions/deposit/")
    fun createDeposit(
        @Field("response") response: String
    ): Call<CreateWalletResponse>

    @FormUrlEncoded
    @POST("transactions/withdraw/")
    fun createWithdraw(
        @Field("response") response: String
    ): Call<CreateWithdrawResponse>

    @FormUrlEncoded
    @POST("transactions/transfer/")
    fun createTransfer(
        @Field("response") response: String
    ): Call<CreateTransferResponse>
}