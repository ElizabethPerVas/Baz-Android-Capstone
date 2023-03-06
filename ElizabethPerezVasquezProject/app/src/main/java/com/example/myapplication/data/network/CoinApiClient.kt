package com.example.myapplication.data.network

import com.example.myapplication.data.model.response.CoinsDetailModelResponse
import com.example.myapplication.data.model.response.CoinsModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.rxjava3.core.Observable

interface CoinApiClient {
    @GET("available_books/")
    suspend fun getAllCoins(): Response<CoinsModelResponse>

    @GET("available_books/")
    fun getAllCoinsRx() : Observable<Response<CoinsModelResponse>>

    @GET("order_book/")
    suspend fun getOrderCoin(
        @Query("book") nameCoin: String?,
        @Query("aggregate") aggregate: Boolean?,
    ): Response<CoinsDetailModelResponse>

}