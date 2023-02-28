package com.example.myapplication.data.model

import com.example.myapplication.data.database.entities.CoinEntity
import com.example.myapplication.data.model.response.CoinModelResponse

data class Coin(
    val nameCoin: String,
    val minimumAmount: String,
    val maximumAmount: String,
    val minimumPrice: String,
    val maximumPrice: String,
    val minimumValue: String,
    val maximunValue: String,
)

fun CoinModelResponse.toDomain() = Coin(
    nameCoin!!,
    minimumAmount!!,
    maximumAmount!!,
    minimumPrice!!,
    maximumPrice!!,
    minimumValue!!,
    maximunValue!!
)

fun CoinEntity.toDomain() = Coin(
    nameCoin,
    minimumAmount,
    maximumAmount,
    minimumPrice,
    maximumPrice,
    minimumValue,
    maximunValue
)