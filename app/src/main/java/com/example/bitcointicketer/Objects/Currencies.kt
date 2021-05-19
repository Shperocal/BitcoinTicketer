package com.example.bitcointicketer.Objects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Currencies(
    @SerializedName("USD")
    @Expose
    var usd: Usd? = null,

    @SerializedName("CAD")
    @Expose
    var cad: Cad? = null,

    @SerializedName("GBP")
    @Expose
    var gbp: Gbp? = null,
    )
