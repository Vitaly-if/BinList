package com.example.binlist.bins.domain

import com.example.binlist.Card
import com.example.binlist.bins.data.CardDetailRepository

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardIterator {
    suspend fun getCard(): Card
    class Base(private val repository: CardDetailRepository): CardIterator {
        override suspend fun getCard(): Card {
            return repository.fetchCardDetail("321")
        }
    }
}