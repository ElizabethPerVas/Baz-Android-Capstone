package com.example.myapplication.data.model

import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import com.example.myapplication.data.model.response.Ask
import com.example.myapplication.data.model.response.Bids

data class CoinDetailBids(
    val book: String,
    val amount: String,
    val price: String,
    val oid: String,
)

fun Bids.toDomain() = CoinDetailBids(
    book,
    amount,
    price,
    oid
)

fun CoinDetailBidsEntity.toDomain() = CoinDetailBids(
    book,
    amount,
    price,
    oid
)