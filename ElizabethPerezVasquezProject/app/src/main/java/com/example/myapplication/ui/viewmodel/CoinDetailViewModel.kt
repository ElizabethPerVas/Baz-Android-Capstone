package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.domain.usecasedetailcoin.GetDetailCoinsRetrofitUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinsDetailRetrofitUseCase: GetDetailCoinsRetrofitUseCase
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
