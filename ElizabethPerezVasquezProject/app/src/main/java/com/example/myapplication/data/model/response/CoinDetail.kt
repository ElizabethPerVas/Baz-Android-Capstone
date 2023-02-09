package com.example.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class CoinDetail(
    @SerializedName("ask") var ask: String,
    @SerializedName("bid") var bid: String,
    @SerializedName("book") var book: String,
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("high") var high: String,
    @SerializedName("last") var last: String,
    @SerializedName("low") var low: String,
    @SerializedName("volume") var volume :String,
    @SerializedName("vwap") var vwap: String
    ) {

}