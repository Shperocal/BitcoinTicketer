package com.example.bitcointicketer.Objects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Usd (
    @SerializedName("15m")
    @Expose
    private var _15m: Double? = null,

    @SerializedName("last")
    @Expose
    var last: Double? = null,

    @SerializedName("buy")
    @Expose
    var buy: Double? = null,

    @SerializedName("sell")
    @Expose
    var sell: Double? = null,

    @SerializedName("symbol")
    @Expose
    var symbol: String? = null
)