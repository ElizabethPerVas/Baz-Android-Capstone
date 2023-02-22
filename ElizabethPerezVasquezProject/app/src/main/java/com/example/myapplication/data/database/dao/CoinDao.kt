package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.database.entities.CoinEntity

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin_table ORDER BY book DESC")
    suspend fun getAllCoins(): List<CoinEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(coins: List<CoinEntity>)

    @Query("DELETE FROM coin_table")
    suspend fun deleteAllCoins()

}