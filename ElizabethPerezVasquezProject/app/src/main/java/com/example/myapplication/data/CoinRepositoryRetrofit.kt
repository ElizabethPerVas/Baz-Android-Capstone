package com.example.myapplication.data

import com.example.myapplication.data.model.CoinProviderRetrofit
import com.example.myapplication.data.model.CoinsModelResponse
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.network.CoinServiceRetrofit

class CoinRepositoryRetrofit {

    private val api = CoinServiceRetrofit()

    suspend fun getAllCoins(): List<CoinModelResponse>{
        var response : List<CoinModelResponse> = api.getCoins()
        CoinProviderRetrofit.coins = response
        return response
    }
}