package com.example.myapplication.data.model

import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.ui.view.fragment.CoinsFragment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinProviderRetrofit {
        companion object{
                var coins: List<CoinModelResponse> = emptyList()
        }
}