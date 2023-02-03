package com.example.myapplication.data.network

import com.example.myapplication.data.model.CoinsModelResponse
import com.example.myapplication.data.model.response.CoinModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoinService (
    private val api : CoinApiClient

) {

//    suspend fun getCoins(): List<CoinsModelResponse>{
//        return withContext(Dispatchers.IO) {
//            val response = api.getAllCoins()
//            response.body() ?: emptyList()
//        }
//    }
}