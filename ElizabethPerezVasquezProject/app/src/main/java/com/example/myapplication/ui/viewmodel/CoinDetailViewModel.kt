package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.domain.usecasedetailcoin.GetDetailCoinsRetrofitUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinDetailViewModel @Inject constructor(
    private val repositoryRetrofit: CoinRepository,
    private val getCoinsDetailRetrofitUseCase: GetDetailCoinsRetrofitUseCase = GetDetailCoinsRetrofitUseCase(
        repositoryRetrofit
    ),
) : ViewModel() {
    private val _coinsDetailLiveData = MutableLiveData<CoinDetail>()
    val coinsDetailLiveData: LiveData<CoinDetail> = _coinsDetailLiveData

    fun getDetailCoin(request: OrderRequest) {
        viewModelScope.launch {
            val result: CoinDetail = getCoinsDetailRetrofitUseCase(request)
            _coinsDetailLiveData.postValue(result)
        }
    }
}
