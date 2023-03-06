package com.example.myapplication.data

import com.example.myapplication.data.database.dao.CoinDao
import com.example.myapplication.data.database.dao.CoinDetailDao
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.database.entities.CoinEntity
import com.example.myapplication.data.model.Coin
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.response.CoinsModelResponse
import com.example.myapplication.data.model.response.OrderResponse
import com.example.myapplication.data.model.toDomain
import com.example.myapplication.data.network.CoinService
import retrofit2.Response
import javax.inject.Inject
import io.reactivex.rxjava3.core.Observable

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

    fun getAllCoinsFromApiRx() : Observable<List<Coin>> {
        return api.getCoinsRx()
            .flatMap { response ->
                val data = response.body()?.payload ?: emptyList()
                Observable.just(data.map {
                    it.toDomain()
                })
            }
    }

    fun insertCoinsRx(coins: List<CoinEntity>) {
        coinDao.insertAllRx(coins)
    }

    suspend fun getAllCoinsFromDatabase(): List<Coin> {
        val response: List<CoinEntity> = coinDao.getAllCoins()
        return response.map {
            it.toDomain()
        }
    }

    fun getAllCoinsFromDatabaseRx(): List<Coin> {
        val response: List<CoinEntity> = coinDao.getAllCoinsRx()
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

    suspend fun getDetailCoinsFromDatabase(): CoinDetail {
        val response: CoinDetailEntity = coinDetailDao.getAllCoins()
        return response.toDomain()
    }

    suspend fun insertDetailCoins(coinDetail: CoinDetailEntity) {
        coinDetailDao.insertDetail(coinDetail)
    }

}