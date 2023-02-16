package com.example.myapplication.di

import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.network.CoinApiClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GeneralModule {

    @Binds
    abstract fun providesCoinRepository(repository: CoinRepository) : CoinRepository

}