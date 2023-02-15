package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.model.response.CoinModelResponse
import com.example.myapplication.domain.usecase.GetCoinsRetrofitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor (
    private val repositoryRetrofit: CoinRepository = CoinRepository(),
    private val getCoinsRetrofitUseCase: GetCoinsRetrofitUseCase = GetCoinsRetrofitUseCase(
        repositoryRetrofit
    ),
) : ViewModel() {
    private val _coinsLiveData = MutableLiveData<List<CoinModelResponse>>()
    val coinsLiveData: LiveData<List<CoinModelResponse>> = _coinsLiveData

    fun getCoin() {
        viewModelScope.launch {
            val result: List<CoinModelResponse> = getCoinsRetrofitUseCase()
            _coinsLiveData.postValue(result)
        }
    }
}
