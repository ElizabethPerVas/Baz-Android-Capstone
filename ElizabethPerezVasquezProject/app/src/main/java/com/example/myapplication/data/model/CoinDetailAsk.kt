package com.example.myapplication.data.model

import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.model.response.Ask

data class CoinDetailAsk(
    val book: String,
    val amount: String,
    val price: String,
    val oid: String,
)

fun Ask.toDomain() = CoinDetailAsk(
    book,
    amount,
    price,
    oid
)

fun CoinDetailAskEntity.toDomain() = CoinDetailAsk(
    book,
    amount,
    price,
    oid
)

fun CoinDetailAsk.toDatabase() = CoinDetailAskEntity(
    book = book,
    amount = amount,
    price = price,
    oid = oid
)