package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CoinRepositoryRetrofit
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.data.model.response.OrderResponse
import com.example.myapplication.domain.GetDetailCoinsRetrofitUseCase
import kotlinx.coroutines.launch

class CoinDetailViewModel (
    private val repositoryRetrofit: CoinRepositoryRetrofit = CoinRepositoryRetrofit(),
    private val getCoinsDetailRetrofitUseCase: GetDetailCoinsRetrofitUseCase = GetDetailCoinsRetrofitUseCase(repositoryRetrofit)
) : ViewModel() {
    private val _coinsDetailLiveData = MutableLiveData<List<OrderResponse>>()
    val coinsDetailLiveData : LiveData<List<OrderResponse>> = _coinsDetailLiveData

    fun getDetailCoin(request: OrderRequest) {
        viewModelScope.launch {
            val result: List<OrderResponse> = getCoinsDetailRetrofitUseCase(request)
            _coinsDetailLiveData.postValue(result)
        }
    }
}
