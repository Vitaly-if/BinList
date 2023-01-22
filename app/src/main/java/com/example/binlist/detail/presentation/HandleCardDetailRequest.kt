package com.example.binlist.detail.presentation

import com.example.binlist.cards.domain.CardDomain
import com.example.binlist.cards.presentation.DispatchersList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface HandleCardDetailRequest {
    fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> CardDomain
    )

    class Base(
        private val dispatchers: DispatchersList,
        private val communication: CardsDetailCommunication,
        private val cardDomainToUiMapper: CardDomain.Mapper<CardDetailUi>,
    ) : HandleCardDetailRequest {

        override fun handle(
            coroutineScope: CoroutineScope,
            block: suspend () -> CardDomain
        ) {
            coroutineScope.launch(dispatchers.io()) {
                val result = block.invoke()
                communication.showCard(result.map(cardDomainToUiMapper))
            }
        }
    }
}