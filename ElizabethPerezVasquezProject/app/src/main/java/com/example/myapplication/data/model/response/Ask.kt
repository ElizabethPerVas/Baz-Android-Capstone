package com.example.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class Ask(
    @SerializedName("book") var book: String,
    @SerializedName("amount") var amount: String,
    @SerializedName("price") var price: String,
    @SerializedName("oid") var oid: String
    ) {

}