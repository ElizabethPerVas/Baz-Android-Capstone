package com.example.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.myapplication.data.database.dao.CoinDao
import com.example.myapplication.data.database.dao.CoinDetailDao
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.database.entities.CoinEntity

@Database(entities = [CoinEntity::class, CoinDetailEntity::class], version = 3)
@TypeConverters(ConverterRoom::class)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun getCoinDao(): CoinDao
    abstract fun getDetailCoinDao(): CoinDetailDao
}