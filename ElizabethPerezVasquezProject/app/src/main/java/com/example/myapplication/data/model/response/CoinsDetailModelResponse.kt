package com.example.myapplication.data.model.response

import com.example.myapplication.data.model.response.OrderResponse
import com.google.gson.annotations.SerializedName

data class CoinsDetailModelResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("payload") var payload: OrderResponse,
)