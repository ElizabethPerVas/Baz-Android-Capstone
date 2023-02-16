package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.database.CoinDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val COIN_DATABASE_NAME = "coin_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CoinDatabase::class.java, COIN_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideCoinDao(db: CoinDatabase) =
        db.getCoinDao()

    @Singleton
    @Provides
    fun provideCoinDetailDao(db: CoinDatabase) =
        db.getDetailCoinDao()
}