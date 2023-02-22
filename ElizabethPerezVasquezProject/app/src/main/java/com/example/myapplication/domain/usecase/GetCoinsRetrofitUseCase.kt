package com.example.myapplication.domain.usecase

import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.database.entities.toDatabase
import com.example.myapplication.data.model.Coin
import javax.inject.Inject

class GetCoinsRetrofitUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    suspend operator fun invoke(): List<Coin> {
        val coins = repository.getAllCoinsFromApi()

        return if (coins.isNotEmpty()) {
            repository.clearCoin()
            repository.insertCoins(coins.map { it.toDatabase() })
            coins
        } else {
            repository.getAllCoinsFromDatabase()
        }
    }
}