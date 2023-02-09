package com.example.myapplication.domain

import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.CoinRepositoryRetrofit
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.OrderResponse

class GetDetailCoinsRetrofitUseCase(
    private val repository : CoinRepositoryRetrofit
) {
    suspend operator fun invoke(request: OrderRequest) : List<OrderResponse> = repository.getDetailCoins(request)
}