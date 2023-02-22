package com.example.myapplication.data.network

import com.example.myapplication.data.model.response.CoinsDetailModelResponse
import com.example.myapplication.data.model.response.CoinsModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface CoinApiClient {
    @GET("available_books/")
    suspend fun getAllCoins(): Response<CoinsModelResponse>

    @GET("order_book/")
    suspend fun getOrderCoin(
        @Query("book") nameCoin: String?,
        @Query("aggregate") aggregate: Boolean?,
    ): Response<CoinsDetailModelResponse>

}