package com.example.myapplication.domain.usecase

import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.database.entities.toCoinDetail
import com.example.myapplication.data.database.entities.toDatabase
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.OrderResponse
import javax.inject.Inject

class GetDetailCoinsRetrofitUseCase @Inject constructor (
    private val repository: CoinRepository,
) {
    suspend operator fun invoke(request: OrderRequest): CoinDetail {
        repository.clearDetailCoins()
        val coinsDe = repository.getDetailCoinsFromApi(request)
        return if (coinsDe.ask!!.isNotEmpty() || coinsDe.bids!!.isNotEmpty()){
            repository.insertDetailCoins(coinsDe.toCoinDetail().toDatabase())
            coinsDe.toCoinDetail()
        }else{
            repository.getDetailCoinsFromDatabase(request)
        }
    }
}
