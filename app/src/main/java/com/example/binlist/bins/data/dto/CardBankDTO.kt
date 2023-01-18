package com.example.binlist.bins.data.dto

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 18.01.2023.
 */
data class CardBankDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("city") val city: String,
)
