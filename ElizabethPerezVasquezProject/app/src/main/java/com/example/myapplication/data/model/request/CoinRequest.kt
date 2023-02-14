package com.example.myapplication.data.model.request

import com.google.gson.annotations.SerializedName

data class CoinRequest(
    @SerializedName("book") var nameCoin: String,
) {}