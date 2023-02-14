package com.example.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.database.dao.CoinDao
import com.example.myapplication.data.database.entities.CoinEntity

@Database(entities = [CoinEntity::class], version = 2)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun getCoinDao(): CoinDao
}