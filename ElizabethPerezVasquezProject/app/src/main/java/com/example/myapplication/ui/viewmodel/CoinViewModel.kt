package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Coin
import com.example.myapplication.domain.usecase.GetCoinsRetrofitUseCase
import com.example.myapplication.domain.usecase.GetCoinsRxUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinsRetrofitUseCase: GetCoinsRetrofitUseCase,
    private val getCoinsRxUseCase: GetCoinsRxUseCase
) : ViewModel() {
    private val _coinsLiveData = MutableLiveData<List<Coin>>()
    val coinsLiveData: LiveData<List<Coin>> = _coinsLiveData

    fun getCoin() {
        viewModelScope.launch {
            val result = getCoinsRetrofitUseCase()
            _coinsLiveData.postValue(result)
        }
    }
    fun getCoinRx() {
        viewModelScope.launch {
            val resultRx =  getCoinsRxUseCase()
            _coinsLiveData.postValue(resultRx)
        }
    }
}
