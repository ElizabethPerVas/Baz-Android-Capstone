package com.example.myapplication.data.network

import com.example.myapplication.data.model.response.CoinsDetailModelResponse
import com.example.myapplication.data.model.response.CoinsModelResponse
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.response.OrderResponse
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class CoinService @Inject constructor(private val api: CoinApiClient) {

    suspend fun getCoins(): List<CoinModelResponse> {
        return withContext(Dispatchers.IO) {
            val response: Response<CoinsModelResponse> =
                api.getAllCoins()
            response.body()?.payload ?: emptyList()
        }
    }

    fun getCoinsRx() : Observable<Response<CoinsModelResponse>> {
        return api.getAllCoinsRx()
    }

    suspend fun getDetail(request: OrderRequest): OrderResponse {
        return withContext(Dispatchers.IO) {
            val response: Response<CoinsDetailModelResponse> =
                api.getOrderCoin(request.nameCoin, request.aggregate)
            response.body()?.payload ?: OrderResponse(listOf(), listOf(), "", "")
        }
    }
}
