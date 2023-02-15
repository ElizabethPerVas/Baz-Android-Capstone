package com.example.myapplication.domain.usecase

import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.CoinRepository
import javax.inject.Inject

class GetCoinsRetrofitUseCase @Inject constructor (
    private val repository : CoinRepository
) {
    suspend operator fun invoke() : List<CoinModelResponse> = repository.getAllCoins()
}