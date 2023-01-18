package com.example.binlist.bins.data.dto

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 18.01.2023.
 */
data class CardNumberDTO(
    @SerializedName("length") val length: String,
    @SerializedName("luhn") val luhn: Boolean
)
