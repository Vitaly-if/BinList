package com.example.binlist.cards.domain

import com.example.binlist.cards.data.CardBankData
import com.example.binlist.cards.data.CardCountryData
import com.example.binlist.cards.data.CardData
import com.example.binlist.cards.data.CardNumberData

/**
 * @author Vitaly.N on 19.01.2023.
 */
class CardDataToDomain : CardData.Mapper<CardDomain> {
    override fun map(
        bin: String,
        number: CardNumberData,
        scheme: String,
        type: String,
        brand: String,
        boolean: Boolean,
        country: CardCountryData,
        bank: CardBankData,
    ): CardDomain {
        return CardDomain(
            bin,
            CardNumberDomain(number.length, number.luhn),
            scheme,
            type,
            brand,
            boolean,
            CardCountryDomain(
                country.numeric, country.alpha2, country.name,
                country.emoji, country.currency, country.latitude, country.longitude
            ),
            CardBankDomain(bank.name, bank.url, bank.phone, bank.city)
        )
    }
}