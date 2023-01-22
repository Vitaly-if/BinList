package com.example.binlist.detail.domain

import com.example.binlist.cards.data.BinCard
import com.example.binlist.cards.data.CardRepository
import com.example.binlist.cards.domain.CardDomain

interface CardDetailInteractor {

    suspend fun fetchCardDetail(): CardDomain

    class Base(private val repository: CardRepository, private val binCard: BinCard.Read) :
        CardDetailInteractor {
        override suspend fun fetchCardDetail(): CardDomain {
            return repository.fetchCardDetail(binCard.read())
        }
    }
}