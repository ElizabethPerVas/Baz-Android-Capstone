package com.example.myapplication.data.network

import com.example.myapplication.data.model.CoinsDetailModelResponse
import com.example.myapplication.data.model.CoinsModelResponse
import com.example.myapplication.data.model.request.OrderRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET


interface CoinApiClient {
   @GET("available_books/")
   suspend fun getAllCoins(): Response <CoinsModelResponse>

   @GET("order_book/")
      suspend fun getOrderCoin(@Body request: OrderRequest): Response <CoinsDetailModelResponse>

}