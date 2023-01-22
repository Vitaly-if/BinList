package com.example.binlist.cards.data

import com.example.binlist.cards.data.cache.CardDetailCacheDataSource
import com.example.binlist.cards.data.cloud.CardDetailCloudDataSource
import com.example.binlist.cards.data.dto.CardDTO
import com.example.binlist.cards.domain.CardDomain

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardRepository {
    suspend fun fetchCard(bin: String)
    suspend fun fetchCardDetail(bin: String): CardDomain
    suspend fun allCards(): List<CardDomain>
    class Base(
        private val cardDetailCloudDataSource: CardDetailCloudDataSource,
        private val cardDetailCacheDataSource: CardDetailCacheDataSource,
        private val dataToDomainMapper: CardData.Mapper<CardDomain>,
        private val dtoToDataMapper: CardDTO.Mapper<CardData>
    ) :
        CardRepository {

        override suspend fun fetchCard(bin: String) {
            val cardDTO = cardDetailCloudDataSource.fetchCardDetail()
            cardDetailCacheDataSource.saveCard(cardDTO.map(dtoToDataMapper, bin))

        }

        override suspend fun fetchCardDetail(bin: String): CardDomain {
            val cardCache = cardDetailCacheDataSource.card(bin)
            return cardCache.map(dataToDomainMapper)
        }

        override suspend fun allCards(): List<CardDomain> {
            val cardsDomain = mutableListOf<CardDomain>()
            cardDetailCacheDataSource.allCards().forEach {
                cardsDomain.add(it.map(dataToDomainMapper))
            }
            return cardsDomain
        }
    }
}