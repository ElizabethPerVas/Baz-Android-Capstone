package com.example.myapplication.data.model.request

import com.google.gson.annotations.SerializedName

data class OrderRequest(
    @SerializedName("aggregate") var aggregate: Boolean,
    @SerializedName("book") var nameCoin: String
    ) {
}