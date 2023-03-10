package com.example.binlist.cards.domain

import com.example.binlist.cards.data.BinCard
import com.example.binlist.cards.data.CardRepository
import kotlinx.coroutines.delay

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardInteractor {
    suspend fun cards(): List<CardDomain>
    suspend fun fetchCard(bin: String): CardsResult
    suspend fun init(): CardsResult
    fun saveBinCard(bin: String)
    class Base(
        private val repository: CardRepository, private val binCard: BinCard.Save,
        private val handleRequest: HandleRequest,
    ) : CardInteractor {
        override suspend fun cards(): List<CardDomain> {
            return repository.allCards()
        }

        override suspend fun fetchCard(bin: String) = handleRequest.handle {
            repository.fetchCard(bin)
        }

        override suspend fun init() = CardsResult.Success(repository.allCards())

        override fun saveBinCard(bin: String) {
            binCard.save(bin)
        }
    }
}