package com.example.binlist.cards.domain

import com.example.binlist.cards.presentation.CardUi

/**
 * @author Vitaly.N on 20.01.2023.
 */
class CardDomainToUiMapper: CardDomain.Mapper<CardUi> {
    override fun map(
        bin: String,
        number: CardNumberDomain,
        scheme: String,
        type: String,
        brand: String,
        boolean: Boolean,
        country: CardCountryDomain,
        bank: CardBankDomain
    ): CardUi {
        return CardUi(bin, scheme)
    }
}