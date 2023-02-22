package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.database.entities.CoinEntity

@Dao
interface CoinDetailDao {

    @Query("SELECT * FROM coin_detail_table ORDER BY ask DESC")
    suspend fun getAllCoins(): CoinDetailEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(coins: CoinDetailEntity)

    @Query("DELETE FROM coin_detail_table")
    suspend fun deleteAllCoins()

}