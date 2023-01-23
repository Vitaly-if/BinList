package com.example.binlist.detail.domain

import com.example.binlist.cards.domain.CardBankDomain
import com.example.binlist.cards.domain.CardCountryDomain
import com.example.binlist.cards.domain.CardDomain
import com.example.binlist.cards.domain.CardNumberDomain
import com.example.binlist.detail.presentation.CardBankDetailUi
import com.example.binlist.detail.presentation.CardCountryDetailUi
import com.example.binlist.detail.presentation.CardDetailUi
import com.example.binlist.detail.presentation.CardNumberDetailUi

class CardDomainToUiDetailMapper : CardDomain.Mapper<CardDetailUi> {
    override fun map(
        bin: String,
        number: CardNumberDomain,
        scheme: String,
        type: String,
        brand: String,
        prepaid: Boolean,
        country: CardCountryDomain,
        bank: CardBankDomain,
    ): CardDetailUi {
        return CardDetailUi(bin,
            CardNumberDetailUi(number.length, number.luhn),
            scheme,
            type,
            brand,
            prepaid,
            CardCountryDetailUi(country.numeric, country.alpha2, country.name,
                country.emoji, country.currency, country.latitude, country.longitude),
            CardBankDetailUi(bank.name, bank.url, bank.phone, bank.city))
    }
}