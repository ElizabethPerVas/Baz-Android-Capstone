package com.example.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class CoinModelResponse(
    @SerializedName("book")
    var nameCoin: String? = null,
    @SerializedName("minium_amount")
    var miniumAmount: String? = null,
    @SerializedName("maximum_amount")
    var maximumAmount: String? = null,
    @SerializedName("minimum_price")
    var miniumPrice: String? = null,
    @SerializedName("maximum_price")
    var maxiumPrice: String? = null,
    @SerializedName("minimum_value")
    var miniumValue: String? = null,
    @SerializedName("maximum_value")
    var maximunValue: String? = null
    ){

}