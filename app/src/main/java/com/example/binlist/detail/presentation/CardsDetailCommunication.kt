package com.example.binlist.detail.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.binlist.main.presentation.Communication

interface CardsDetailCommunication : ObserveCardsDetail {

    fun showCard(card: CardDetailUi)

    class Base(
        private val cardDetail: CardDetailCommunication
    ) : CardsDetailCommunication {
        override fun showCard(card: CardDetailUi) = cardDetail.map(card)

        override fun observeCard(owner: LifecycleOwner, observer: Observer<CardDetailUi>) {
            cardDetail.observe(owner, observer)
        }
    }
}

interface ObserveCardsDetail {
    fun observeCard(owner: LifecycleOwner, observer: Observer<CardDetailUi>)
}

interface CardDetailCommunication : Communication.Mutable<CardDetailUi> {
    class Base : Communication.Post<CardDetailUi>(), CardDetailCommunication
}