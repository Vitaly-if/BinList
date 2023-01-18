package com.example.binlist.cards.data.cache

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface CardDetailCacheDataSourse {

    suspend fun allCards(): List<CardData>

    suspend fun card(bin: String): CardData

    suspend fun saveCard(cardData: CardData)

    class Base(
        private val dao: CardsDao,
        private val dataToCache: CardData.Mapper<CardCache>,
    ) : CardDetailCacheDataSourse {
        override suspend fun allCards(): List<CardData> {
            val data = dao.allCards()
            return data.map { CardData(it.number) }
        }

        override suspend fun card(bin: String): CardData {
            val data = dao.card(bin)
            return data != null
        }

        override suspend fun saveCard(cardData: CardData) {
            dao.insert(cardData.map(dataToCache))
        }
    }
}