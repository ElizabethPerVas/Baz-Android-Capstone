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
    @ColumnInfo(name = "minimum_amount") val minimumAmount: String,
    @ColumnInfo(name = "maximum_amount") val maximumAmount: String,
    @ColumnInfo(name = "minimum_price") val minimumPrice: String,
    @ColumnInfo(name = "maximum_price") val maximumPrice: String,
    @ColumnInfo(name = "minimum_value") val minimumValue: String,
    @ColumnInfo(name = "maximum_value") val maximumValue: String,
)

fun Coin.toDatabase() = CoinEntity(
    nameCoin = nameCoin,
    minimumAmount = minimumAmount,
    maximumAmount = maximumAmount,
    minimumPrice = minimumPrice,
    maximumPrice = maximumPrice,
    minimumValue = minimumValue,
    maximumValue = maximumValue
)
