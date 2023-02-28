package com.example.myapplication.data

import com.example.myapplication.data.database.dao.CoinDao
import com.example.myapplication.data.database.dao.CoinDetailDao
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.database.entities.CoinEntity
import com.example.myapplication.data.model.Coin
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.response.OrderResponse
import com.example.myapplication.data.model.toDomain
import com.example.myapplication.data.network.CoinService
import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val api: CoinService,
    private val coinDao: CoinDao,
    private val coinDetailDao: CoinDetailDao,
) {

    suspend fun getAllCoinsFromApi(): List<Coin> {
        val response: List<CoinModelResponse> = api.getCoins()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAllCoinsFromDatabase(): List<Coin> {
        val response: List<CoinEntity> = coinDao.getAllCoins()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertCoins(coins: List<CoinEntity>) {
        coinDao.insertAll(coins)
    }

    suspend fun clearCoin() {
        coinDao.deleteAllCoins()
    }

    suspend fun getDetailCoinsFromApi(request: OrderRequest): CoinDetail {
        val response: OrderResponse = api.getDetail(request)
        return response.toDomain()
    }

    suspend fun getDetailCoinsFromDatabase(request: OrderRequest): CoinDetail {
        val response: CoinDetailEntity = coinDetailDao.getAllCoins()
        return response.toDomain()
    }

    suspend fun insertDetailCoins(coinDetail: CoinDetailEntity) {
        coinDetailDao.insertAll(coinDetail)
    }

    suspend fun clearDetailCoins() {
        coinDetailDao.deleteAllCoins()
    }

}