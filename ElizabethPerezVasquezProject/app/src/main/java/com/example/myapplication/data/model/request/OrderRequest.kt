package com.example.myapplication.data.model.request

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderRequest(
    @SerializedName("aggregate") var aggregate: Boolean,
    @SerializedName("book") var nameCoin: String? = null,
) : Serializable {
}