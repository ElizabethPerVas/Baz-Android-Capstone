package com.example.myapplication.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_table")
data class CoinEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val idCoin: Int = 0,
    @ColumnInfo(name = "nameCoin") val nameCoin: String,
    @ColumnInfo(name = "descriptionCoin") val descriptionCoin: String,
) {
}