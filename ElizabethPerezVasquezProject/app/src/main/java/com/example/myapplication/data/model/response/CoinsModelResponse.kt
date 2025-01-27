package com.example.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class CoinsModelResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("payload") var payload: List<CoinModelResponse>,
)