package com.example.binlist.cards.domain

/**
 * @author Vitaly.N on 19.01.2023.
 */
data class CardDomain(
    private val bin: String,
    private val number: CardNumberDomain,
    private val scheme: String,
    private val type: String,
    private val brand: String,
    private val boolean: Boolean,
    private val country: CardCountryDomain,
    private val bank: CardBankDomain,
) {
    interface Mapper<T> {
        fun map(
            bin: String,
            number: CardNumberDomain,
            scheme: String,
            type: String,
            brand: String,
            boolean: Boolean,
            country: CardCountryDomain,
            bank: CardBankDomain,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(bin, number, scheme, type,
        brand,
        boolean,
        country,
        bank)
}

data class CardNumberDomain(
    val length: String,
    val luhn: Boolean,
)

data class CardCountryDomain(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int,
)

data class CardBankDomain(
    val name: String,
    val url: String,
    val phone: String,
    val city: String,
)

