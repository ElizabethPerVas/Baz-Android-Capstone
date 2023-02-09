package com.example.myapplication.data.model

import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.response.OrderResponse

import javax.inject.Singleton

@Singleton
class CoinProviderRetrofit {
        companion object{
                var coins: List<CoinModelResponse> = emptyList()
                var detail: List<OrderResponse> = emptyList()
        }
}