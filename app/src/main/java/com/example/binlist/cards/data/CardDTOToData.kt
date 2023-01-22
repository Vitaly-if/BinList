package com.example.binlist.cards.data

import android.util.Log
import com.example.binlist.cards.data.dto.CardBankDTO
import com.example.binlist.cards.data.dto.CardCountryDTO
import com.example.binlist.cards.data.dto.CardDTO
import com.example.binlist.cards.data.dto.CardNumberDTO

/**
 * @author Vitaly.N on 19.01.2023.
 */
class CardDTOToData : CardDTO.Mapper<CardData> {

    override fun map(
        bin: String,
        number: CardNumberDTO,
        scheme: String,
        type: String,
        brand: String,
        boolean: Boolean,
        country: CardCountryDTO,
        bank: CardBankDTO?,
    ): CardData {
        Log.i("vital", "")
        var bankData = if (bank == null)
            CardBankData("", "", "", "")
        else
        CardBankData(bank.name, bank.url, bank.phone, bank.city)
        return CardData(
            bin,
            CardNumberData(number.length, number.luhn),
            scheme,
            type,
            brand,
            boolean,
            CardCountryData(
                country.numeric, country.alpha2, country.name,
                country.emoji, country.currency, country.latitude, country.longitude
            ),
            bankData
        )
    }
}