package com.example.binlist.cards.data

import com.example.binlist.cards.data.cache.CardBankCache
import com.example.binlist.cards.data.cache.CardCache
import com.example.binlist.cards.data.cache.CardCountryCache
import com.example.binlist.cards.data.cache.CardNumberCache

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardDataToCache : CardData.Mapper<CardCache> {
    override fun map(
        bin: String,
        number: CardNumberData,
        scheme: String,
        type: String,
        brand: String,
        prepaid: Boolean,
        country: CardCountryData,
        bank: CardBankData,
    ): CardCache {
        return CardCache(
            bin,
            CardNumberCache(number.length, number.luhn),
            scheme,
            type,
            brand,
            prepaid,
            CardCountryCache(
                country.numeric, country.alpha2, country.name,
                country.emoji, country.currency, country.latitude, country.longitude
            ),
            CardBankCache(bank.name, bank.url, bank.phone, bank.city)
        )
    }
}