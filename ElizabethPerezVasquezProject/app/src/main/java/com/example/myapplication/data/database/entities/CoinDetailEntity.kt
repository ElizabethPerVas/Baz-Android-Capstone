package com.example.myapplication.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.CoinDetailAsk
import com.example.myapplication.data.model.CoinDetailBids
import com.example.myapplication.data.model.response.Ask
import com.example.myapplication.data.model.response.Bids
import com.example.myapplication.data.model.response.OrderResponse
import dagger.multibindings.ClassKey

@Entity(tableName = "coin_detail_table")
data class CoinDetailEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val idDetailCoin: Int = 0,
    @ColumnInfo(name = "ask") val ask: List<CoinDetailAskEntity>,
    @ColumnInfo(name = "bids") val bids: List<CoinDetailBidsEntity>,
    @ColumnInfo(name = "sequence") val sequence: Long,
    @ColumnInfo(name = "update_at") val update_at: String
)

fun CoinDetail.toDatabase() = CoinDetailEntity(
    ask = ask,
    bids = bids,
    sequence = sequence,
    update_at = update_at
)

fun OrderResponse.toCoinDetail() = CoinDetail(
    ask = ask,
    bids = bids,
    sequence = sequence,
    update_at = updateAt
)
