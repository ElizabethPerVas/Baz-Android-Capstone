package com.example.myapplication.data.model

import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.response.OrderResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinProvider @Inject constructor() {
    var coins: List<CoinModelResponse> = emptyList()
    var detail: OrderResponse = OrderResponse(null, null, null, null)
}