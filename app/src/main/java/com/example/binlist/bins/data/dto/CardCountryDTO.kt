package com.example.binlist.bins.data.dto

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 18.01.2023.
 */
data class CardCountryDTO(
    @SerializedName("numeric") val numeric: String,
    @SerializedName("alpha2") val alpha2: String,
    @SerializedName("name") val name: String,
    @SerializedName("emoji") val emoji: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("latitude") val latitude: Int,
    @SerializedName("longitude") val longitude: Int,
)
