package com.example.myapplication.data.model.response

import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("ask") var ask: ArrayList<BidsAsk> = ArrayList(),
    @SerializedName("bids") var bids: ArrayList<BidsAsk> = ArrayList(),
    @SerializedName("sequence") var sequence: Long,
    @SerializedName("update_at") var updateAt: String
    ) {

}