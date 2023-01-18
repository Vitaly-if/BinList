package com.example.binlist.cards.data

/**
 * @author Vitaly.N on 18.01.2023.
 */
data class CardData(
    private val bin: String,
    private val number: CardNumberData,
    private val scheme: String,
    private val type: String,
    private val brand: String,
    private val boolean: Boolean,
    private val country: CardCountryData,
    private val bank: CardBankData,
) {
    interface Mapper<T> {
        fun map(
            bin: String,
            number: CardNumberData,
            scheme: String,
            type: String,
            brand: String,
            boolean: Boolean,
            country: CardCountryData,
            bank: CardBankData,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(bin, number, scheme, type,
        brand,
        boolean,
        country,
        bank)
}

data class CardNumberData(
    private val length: String,
    private val luhn: Boolean,
)

data class CardCountryData(
    private val numeric: String,
    private val alpha2: String,
    private val name: String,
    private val emoji: String,
    private val currency: String,
    private val latitude: Int,
    private val longitude: Int,
)

data class CardBankData(
    private val name: String,
    private val url: String,
    private val phone: String,
    private val city: String,
)
