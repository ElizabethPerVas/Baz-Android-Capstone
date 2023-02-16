package com.example.myapplication.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.model.Coin

@Entity(tableName = "coin_table")
data class CoinEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val idCoin: Int = 0,
    @ColumnInfo(name = "book") val nameCoin: String,
    @ColumnInfo(name = "minium_amount") val miniumAmount: String,
    @ColumnInfo(name = "maximum_amount") val maximumAmount: String,
    @ColumnInfo(name = "minimum_price") val miniumPrice: String,
    @ColumnInfo(name = "maximum_price") val maxiumPrice: String,
    @ColumnInfo(name = "minimum_value") val miniumValue: String,
    @ColumnInfo(name = "maximum_value") val maximunValue: String
)

fun Coin.toDatabase() = CoinEntity(
    nameCoin = nameCoin,
    miniumAmount = miniumAmount,
    maximumAmount = maximumAmount,
    miniumPrice = miniumPrice,
    maxiumPrice = maxiumPrice,
    miniumValue = miniumValue,
    maximunValue = maximunValue
    )
