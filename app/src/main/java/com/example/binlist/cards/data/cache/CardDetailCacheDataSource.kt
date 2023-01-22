package com.example.binlist.cards.data.cache

import com.example.binlist.cards.data.CardBankData
import com.example.binlist.cards.data.CardCountryData
import com.example.binlist.cards.data.CardData
import com.example.binlist.cards.data.CardNumberData

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface CardDetailCacheDataSource {

    suspend fun allCards(): List<CardData>

    suspend fun card(bin: String): CardData

    suspend fun saveCard(cardData: CardData)

    class Base(
        private val dao: CardsDao,
        private val dataToCache: CardData.Mapper<CardCache>,
    ) : CardDetailCacheDataSource {
        override suspend fun allCards(): List<CardData> {
            val data = dao.allCards()
            return data.map {
                CardData(
                    it.bin, CardNumberData(it.number.length, it.number.luhn),
                    it.scheme, it.type, it.brand, it.boolean, CardCountryData(
                        it.country.numeric,
                        it.country.alpha2,
                        it.country.name,
                        it.country.emoji,
                        it.country.currency,
                        it.country.latitude,
                        it.country.longitude
                    ), CardBankData(
                        it.bank.name,
                        it.bank.url,
                        it.bank.phone,
                        it.bank.city
                    )
                )
            }
        }

        override suspend fun card(bin: String): CardData {
            val data = dao.card(bin)
            if (data != null) {
                return CardData(
                    data.bin, CardNumberData(data.number.length, data.number.luhn),
                    data.scheme, data.type, data.brand, data.boolean, CardCountryData(
                        data.country.numeric,
                        data.country.alpha2,
                        data.country.name,
                        data.country.emoji,
                        data.country.currency,
                        data.country.latitude,
                        data.country.longitude
                    ), CardBankData(
                        data.bank.name,
                        data.bank.url,
                        data.bank.phone,
                        data.bank.city
                    )
                )
            }
            return CardData(
                "", CardNumberData("", true), "", "",
                "", false, CardCountryData(
                    "", "", "", "",
                    "", 0, 0
                ), CardBankData(
                    "", "", "",
                    ""
                )
            )
        }

        override suspend fun saveCard(cardData: CardData) {
            dao.insert(cardData.map(dataToCache))
        }
    }


}
