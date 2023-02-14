package com.example.myapplication.domain.usecase

import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.CoinRepositoryRetrofit

class GetCoinsRetrofitUseCase(
    private val repository : CoinRepositoryRetrofit
) {
    suspend operator fun invoke() : List<CoinModelResponse> = repository.getAllCoins()
}