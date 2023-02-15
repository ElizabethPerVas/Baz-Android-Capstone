package com.example.myapplication.data

import com.example.myapplication.data.model.CoinProvider
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.response.OrderResponse
import com.example.myapplication.data.network.CoinService
import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val api: CoinService,
    private val coinProvider: CoinProvider
    ) {

    suspend fun getAllCoins(): List<CoinModelResponse> {
        var response: List<CoinModelResponse> = api.getCoins()
        coinProvider.coins = response
        return response
    }

    suspend fun getDetailCoins(request: OrderRequest): OrderResponse {
        var response: OrderResponse = api.getDetail(request)
        coinProvider.detail = response
        return response
    }

}