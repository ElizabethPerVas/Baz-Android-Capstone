package com.example.myapplication.domain.usecase

import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.OrderResponse
import javax.inject.Inject

class GetDetailCoinsRetrofitUseCase @Inject constructor (
    private val repository: CoinRepository,
) {
    suspend operator fun invoke(request: OrderRequest): OrderResponse =
        repository.getDetailCoins(request)
}