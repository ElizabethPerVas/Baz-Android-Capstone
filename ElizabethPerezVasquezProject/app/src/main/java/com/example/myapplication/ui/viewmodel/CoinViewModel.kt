package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CoinRepositoryRetrofit
import com.example.myapplication.data.model.CoinsModelResponse
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.domain.GetCoinsRetrofitUseCase
import kotlinx.coroutines.launch

class CoinViewModel (
    private val repositoryRetrofit: CoinRepositoryRetrofit = CoinRepositoryRetrofit(),
    private val getCoinsRetrofitUseCase: GetCoinsRetrofitUseCase = GetCoinsRetrofitUseCase(repositoryRetrofit)
) : ViewModel() {
    private val _coinsLiveData = MutableLiveData<List<CoinModelResponse>>()
    val coinsLiveData : LiveData<List<CoinModelResponse>> = _coinsLiveData

    fun getCoin() {
        viewModelScope.launch {
            val result: List<CoinModelResponse> = getCoinsRetrofitUseCase()
            _coinsLiveData.postValue(result)
        }
    }
}
