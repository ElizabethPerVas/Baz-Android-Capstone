package com.example.myapplication.domain.usecase

import com.example.myapplication.data.CoinRepositoryRetrofit
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.OrderResponse

class GetDetailCoinsRetrofitUseCase(
    private val repository: CoinRepositoryRetrofit,
) {
    suspend operator fun invoke(request: OrderRequest): OrderResponse =
        repository.getDetailCoins(request)
}