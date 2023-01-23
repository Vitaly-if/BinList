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
        type: String?,
        brand: String?,
        prepaid: Boolean,
        country: CardCountryDTO,
        bank: CardBankDTO?,
    ): CardData {
        var bankData = if (bank == null)
            CardBankData("", "", "", "")
        else
            CardBankData(bank.name, bank.url, bank.phone, bank.city)
        var countryData = if (country == null)
            CardCountryData("", "", "", "", "", 0, 0)
        else
            CardCountryData(
                country.numeric, country.alpha2, country.name,
                country.emoji, country.currency, country.latitude, country.longitude
            )
        var brandData = if (brand == null)
            ""
        else brand
        var typeData = if (type == null)
            ""
        else type
        return CardData(
            bin,
            CardNumberData(number.length, number.luhn),
            scheme,
            typeData,
            brandData,
            prepaid,
            countryData,
            bankData
        )
    }
}