package com.example.myapplication.data.database

import androidx.room.TypeConverter
import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import com.google.gson.Gson


class ConverterRoom {
    @TypeConverter
    fun listToJsonAsk(value: List<CoinDetailAskEntity>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListAsk(value: String) = Gson().fromJson(value, Array<CoinDetailAskEntity>::class.java).toList()

    @TypeConverter
    fun listToJsonBids(value: List<CoinDetailBidsEntity>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListBids(value: String) = Gson().fromJson(value, Array<CoinDetailBidsEntity>::class.java).toList()
}
