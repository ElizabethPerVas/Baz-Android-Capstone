package com.example.myapplication.domain.usecase

import android.annotation.SuppressLint
import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.database.entities.toDatabase
import com.example.myapplication.data.model.Coin
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class GetCoinsRxUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    @SuppressLint("CheckResult")
    operator fun invoke(): List<Coin> {
        val coins = repository
            .getAllCoinsFromApiRx()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .blockingFirst()
        return if(coins.isNotEmpty()){
            repository.insertCoinsRx(coins.map {
                it.toDatabase()
            })
            coins
        } else{
            repository.getAllCoinsFromDatabaseRx()
        }
    }
}