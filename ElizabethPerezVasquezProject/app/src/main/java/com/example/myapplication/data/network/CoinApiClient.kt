package com.example.myapplication.data.network

import com.example.myapplication.data.model.CoinsModelResponse
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.request.CoinRequest
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.CoinDetail
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET


interface CoinApiClient {
   @GET("available_books/")
   suspend fun getAllCoins(): Response <CoinsModelResponse>

   @GET("ticker/")
   suspend fun getDetailCoins(@Body request: CoinRequest): Response <List<CoinDetail >>

   @GET("order_book/")
   suspend fun getOrderCoin(@Body request: OrderRequest): Response <List<CoinModelResponse>>

}