package com.example.myapplication.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderResponse(
    @SerializedName("ask") var ask: List<BidsAsk>?,
    @SerializedName("bids") var bids: List<BidsAsk>?,
    @SerializedName("sequence") var sequence: Long?,
    @SerializedName("update_at") var updateAt: String?,
) : Serializable {

}