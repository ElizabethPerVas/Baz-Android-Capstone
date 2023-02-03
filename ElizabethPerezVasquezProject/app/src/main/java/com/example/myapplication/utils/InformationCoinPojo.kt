package com.example.myapplication.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class InformationCoinPojo(
    internal var nameCoin: String? = "",
    internal var miniumAmount: String? = "",
    internal var maximumAmount: String? = "",
    internal var miniumPrice: String? = "",
    internal var maxiumPrice: String? = "",
    internal var miniumValue: String? = "",
    internal var maximunValue: String? = ""
): Parcelable