package com.example.myapplication.data.model.response

import com.example.myapplication.data.database.entities.CoinDetailAskEntity
import com.example.myapplication.data.database.entities.CoinDetailBidsEntity
import com.example.myapplication.data.database.entities.CoinDetailEntity
import com.example.myapplication.data.model.CoinDetailAsk
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderResponse(
    @SerializedName("asks") var asks: List<CoinDetailAskEntity>,
    @SerializedName("bids") var bids: List<CoinDetailBidsEntity>,
    @SerializedName("sequence") var sequence: String,
    @SerializedName("updated_at") var updatedAt: String,
) : Serializable {

}