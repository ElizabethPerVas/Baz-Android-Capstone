package com.example.myapplication.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.model.CoinDetail
import com.example.myapplication.data.model.response.OrderResponse
import java.io.Serializable

@Entity(tableName = "coin_detail_table")
data class CoinDetailEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val idDetailCoin: Int = 0,
    @ColumnInfo(name = "asks") val asks: List<CoinDetailAskEntity>,
    @ColumnInfo(name = "bids") val bids: List<CoinDetailBidsEntity>,
    @ColumnInfo(name = "sequence") val sequence: String,
    @ColumnInfo(name = "updated_at") val updated_at: String,
) : Serializable

fun CoinDetail.toDatabase() = CoinDetailEntity(
    asks = asks,
    bids = bids,
    sequence = sequence,
    updated_at = updated_at
)

fun OrderResponse.toCoinDetail() = CoinDetail(
    asks = asks,
    bids = bids,
    sequence = sequence,
    updated_at = updatedAt
)
