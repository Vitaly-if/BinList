package com.example.binlist.cards.domain

import com.example.binlist.Card
import com.example.binlist.cards.data.CardDetailRepository

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardIterator {
    suspend fun cards(): List<CardDomain>
    suspend fun fetchCard(bin: String)
    class Base(private val repository: CardDetailRepository): CardIterator {
        override suspend fun cards(): List<CardDomain> {
            return repository.allCards()
        }

        override suspend fun fetchCard(bin: String) {
            repository.fetchCardDetail(bin)
        }
    }
}