package com.example.myapplication.data.model

import com.example.myapplication.data.database.entities.CoinEntity
import com.example.myapplication.data.model.response.CoinModelResponse

data class Coin(
    val nameCoin: String,
    val miniumAmount: String,
    val maximumAmount: String,
    val miniumPrice: String,
    val maxiumPrice: String,
    val miniumValue: String,
    val maximunValue: String
    )

fun CoinModelResponse.toDomain() = Coin(
    nameCoin!!,
    miniumAmount!!,
    maximumAmount!!,
    miniumPrice!!,
    maxiumPrice!!,
    miniumValue!!,
    maximunValue!!
)

fun CoinEntity.toDomain() = Coin(
    nameCoin,
    miniumAmount,
    maximumAmount,
    miniumPrice,
    maxiumPrice,
    miniumValue,
    maximunValue
)