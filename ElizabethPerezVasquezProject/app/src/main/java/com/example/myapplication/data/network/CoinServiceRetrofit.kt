package com.example.myapplication.data.network

import com.example.myapplication.core.RetrofitHelper
import com.example.myapplication.data.model.response.CoinsDetailModelResponse
import com.example.myapplication.data.model.response.CoinsModelResponse
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.data.model.response.OrderResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoinServiceRetrofit {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getCoins(): List<CoinModelResponse> {
        return withContext(Dispatchers.IO) {
            val response: Response<CoinsModelResponse> =
                retrofit.create(CoinApiClient::class.java).getAllCoins()
            response.body()?.payload ?: emptyList()
        }
    }

    suspend fun getDetail(request: OrderRequest): OrderResponse {
        return withContext(Dispatchers.IO) {
            val response: Response<CoinsDetailModelResponse> =
                retrofit.create(CoinApiClient::class.java).getOrderCoin(request.nameCoin, request.aggregate)
            response.body()?.payload ?: OrderResponse(null, null, null, null)
        }
    }
}
