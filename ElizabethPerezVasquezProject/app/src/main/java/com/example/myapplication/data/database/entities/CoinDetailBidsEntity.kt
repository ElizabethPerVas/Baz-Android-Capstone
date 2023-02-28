package com.example.myapplication.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_detail_ask_table")
data class CoinDetailBidsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val idDetailBidsCoin: Int = 0,
    @ColumnInfo(name = "book") val book: String,
    @ColumnInfo(name = "amount") val amount: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "oid") val oid: String? = null
) {
}
