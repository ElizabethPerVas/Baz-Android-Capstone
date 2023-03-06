package com.example.myapplication.data.model

import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.model.response.OrderResponse

data class CoinDetail(
    val asks: List<CoinDetailAskEntity>,
    val bids: List<CoinDetailBidsEntity>,
    val sequence: String,
    val updated_at: String,
)

fun OrderResponse.toDomain() = CoinDetail(
    asks = asks,
    bids = bids,
    sequence,
    updatedAt
)

fun CoinDetailEntity.toDomain() = CoinDetail(
    asks,
    bids,
    sequence,
    updated_at
)