package com.example.myapplication.data.network

import com.example.myapplication.core.RetrofitHelper
import com.example.myapplication.data.model.CoinsModelResponse
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.ui.view.fragment.CoinsFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoinServiceRetrofit {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getCoins(): List<CoinModelResponse> {
        return withContext(Dispatchers.IO){
            val response: Response<CoinsModelResponse> = retrofit.create(CoinApiClient::class.java).getAllCoins()
            response.body()?.payload ?: emptyList()
        }
    }
}
