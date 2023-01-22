package com.example.binlist.cards.data.dto

import com.google.gson.annotations.SerializedName

/**
 * @author Vitaly.N on 18.01.2023.
 */
data class CardDTO(
    @SerializedName("number") val number: CardNumberDTO = CardNumberDTO(),
    @SerializedName("scheme") val scheme: String = "",
    @SerializedName("type") val type: String = "",
    @SerializedName("brand") val brand: String = "",
    @SerializedName("prepaid") val boolean: Boolean = false,
    @SerializedName("country") val country: CardCountryDTO = CardCountryDTO(),
    @SerializedName("bank") val bank: CardBankDTO? = CardBankDTO(),
) {
    interface Mapper<T> {
        fun map(
            bin: String,
            number: CardNumberDTO,
            scheme: String,
            type: String,
            brand: String,
            boolean: Boolean,
            country: CardCountryDTO,
            bank: CardBankDTO?,
        ): T
    }

    fun <T> map(mapper: Mapper<T>, bin: String): T = mapper.map(
        bin, number, scheme, type,
        brand,
        boolean,
        country,
        bank
    )
}
