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
    private val prepaid: Boolean,
    private val country: CardCountryData,
    private val bank: CardBankData = CardBankData("", "", "", ""),
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

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        bin, number, scheme, type,
        brand,
        prepaid,
        country,
        bank
    )
}

data class CardNumberData(
    val length: String,
    val luhn: Boolean,
)

data class CardCountryData(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int,
)

data class CardBankData(
    val name: String,
    val url: String,
    val phone: String,
    val city: String,
)
