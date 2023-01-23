package com.example.binlist.detail.presentation

data class CardDetailUi(
    private val bin: String,
    private val number: CardNumberDetailUi,
    private val scheme: String,
    private val type: String,
    private val brand: String,
    private val prepaid: Boolean,
    private val country: CardCountryDetailUi,
    private val bank: CardBankDetailUi,
) {
    interface Mapper<T> {
        fun map(
            bin: String,
            number: CardNumberDetailUi,
            scheme: String,
            type: String,
            brand: String,
            boolean: Boolean,
            country: CardCountryDetailUi,
            bank: CardBankDetailUi,
        ): T
    }

    fun <T> map(mapper: Mapper<T>): T = mapper.map(bin, number, scheme, type,
        brand,
        prepaid,
        country,
        bank)
}

data class CardNumberDetailUi(
    val length: String,
    val luhn: Boolean,
)

data class CardCountryDetailUi(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int,
)

data class CardBankDetailUi(
    val name: String,
    val url: String,
    val phone: String,
    val city: String,
)


