package com.example.binlist.cards.data

import android.util.Log
import com.example.binlist.Card
import com.example.binlist.cards.data.cache.CardCache
import com.example.binlist.cards.data.cache.CardDetailCacheDataSource
import com.example.binlist.cards.data.cloud.CardDetailCloudDataSource
import com.example.binlist.cards.data.dto.CardDTO
import com.example.binlist.cards.domain.CardDomain

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardDetailRepository {
    suspend fun fetchCardDetail(bin : String): Card
    suspend fun allCards() : List<CardDomain>
    class Base(private val cardDetailCloudDataSource: CardDetailCloudDataSource,
    private val cardDetailCacheDataSource: CardDetailCacheDataSource,
    private val dataToDomainMapper: CardData.Mapper<CardDomain>,
    private val dToToDataMapper: CardDTO.Mapper<CardData>):
        CardDetailRepository {
        override suspend fun fetchCardDetail(bin: String): Card {
            val cardDTO = cardDetailCloudDataSource.fetchCardDetail()
            cardDetailCacheDataSource.saveCard(cardDTO.map(dToToDataMapper,bin))
            Log.i("Vital", cardDTO.toString())
            return Card("Repository")
        }

        override suspend fun allCards(): List<CardDomain> {
            val cardsDomain = mutableListOf<CardDomain>()
            cardDetailCacheDataSource.allCards().forEach {
                cardsDomain.add(it.map(dataToDomainMapper)) }
            return cardsDomain
        }
    }
}