package com.example.myapplication.data.model

import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.database.entities.CoinEntity
import com.example.myapplication.data.model.response.Ask
import com.example.myapplication.data.model.response.Bids
import com.example.myapplication.data.model.response.OrderResponse

data class CoinDetail(
    val ask: List<CoinDetailAskEntity>,
    val bids: List<CoinDetailBidsEntity>,
    val sequence: Long,
    val update_at: String,
)

fun OrderResponse.toDomain() = CoinDetail(
    ask = ask,
    bids = bids,
    sequence,
    updateAt
)

fun CoinDetailEntity.toDomain() = CoinDetail(
    ask,
    bids,
    sequence,
    update_at
)