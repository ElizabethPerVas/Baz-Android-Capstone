package com.example.myapplication.domain.usecasedetailcoin

import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.database.entities.toDatabase
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.request.OrderRequest
import javax.inject.Inject

class GetDetailCoinsRetrofitUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    suspend operator fun invoke(request: OrderRequest): CoinDetail {
        val coinsDe = repository.getDetailCoinsFromApi(request)
        repository.insertDetailCoins(coinsDe.toDatabase())
        return repository.getDetailCoinsFromDatabase()

    }
}
