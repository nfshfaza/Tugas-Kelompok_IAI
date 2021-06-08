package com.example.moneycomefirst

import retrofit2.Call
import retrofit2.http.*

interface Api {
    @Headers("Authorization : Token 5e48dec1672c0eeee4ffdf5020c0ca2fb719b08e")
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
    @Headers("Authorization : Token 5e48dec1672c0eeee4ffdf5020c0ca2fb719b08e")
    @POST("transactions/create-wallet/")
    fun createWallet(
        @Field("response") response: String
    ): Call<CreateWalletResponse>

    @FormUrlEncoded
    @Headers("Authorization : Token 5e48dec1672c0eeee4ffdf5020c0ca2fb719b08e")
    @POST("transactions/deposit/")
    fun createDeposit(
        @Field("response") response: String
    ): Call<CreateWalletResponse>

    @FormUrlEncoded
    @Headers("Authorization : Token 5e48dec1672c0eeee4ffdf5020c0ca2fb719b08e")
    @POST("transactions/withdraw/")
    fun createWithdraw(
        @Field("response") response: String
    ): Call<CreateWithdrawResponse>

    @FormUrlEncoded
    @Headers("Authorization : Token 5e48dec1672c0eeee4ffdf5020c0ca2fb719b08e")
    @POST("transactions/transfer/")
    fun createTransfer(
        @Field("response") response: String
    ): Call<CreateTransferResponse>
}