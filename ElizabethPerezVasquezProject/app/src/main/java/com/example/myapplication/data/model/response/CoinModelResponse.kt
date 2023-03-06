package com.example.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class CoinModelResponse(
    @SerializedName("book")
    var nameCoin: String,
    @SerializedName("minimum_amount")
    var minimumAmount: String,
    @SerializedName("maximum_amount")
    var maximumAmount: String,
    @SerializedName("minimum_price")
    var minimumPrice: String,
    @SerializedName("maximum_price")
    var maximumPrice: String,
    @SerializedName("minimum_value")
    var minimumValue: String,
    @SerializedName("maximum_value")
    var maximumValue: String,
)