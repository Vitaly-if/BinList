package com.example.binlist.cards.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.binlist.main.presentation.Communication

/**
 * @author Vitaly.N on 20.01.2023.
 */
interface CardsCommunication : ObserveCards {

    fun showProgress(show: Int)

    fun showState(uiState: UiState)

    fun showList(list: List<CardUi>)

    class Base(
        private val progress: ProgressCommunication,
        private val state: CardsStateCommunication,
        private val cardsList: CardsListCommunication
    ) : CardsCommunication {

        override fun showProgress(show: Int) = progress.map(show)

        override fun showState(uiState: UiState) = state.map(uiState)

        override fun showList(list: List<CardUi>) = cardsList.map(list)

        override fun observerProgress(owner: LifecycleOwner, observer: Observer<Int>) {
            progress.observe(owner, observer)
        }

        override fun observerState(owner: LifecycleOwner, observer: Observer<UiState>) {
            state.observe(owner, observer)
        }

        override fun observeList(owner: LifecycleOwner, observer: Observer<List<CardUi>>) {
            cardsList.observe(owner, observer)
        }

    }
}

interface ObserveCards {

    fun observerProgress(owner: LifecycleOwner, observer: Observer<Int>)

    fun observerState(owner: LifecycleOwner, observer: Observer<UiState>)

    fun observeList(owner: LifecycleOwner, observer: Observer<List<CardUi>>)

}

interface ProgressCommunication : Communication.Mutable<Int> {
    class Base : Communication.Post<Int>(), ProgressCommunication
}

interface CardsStateCommunication : Communication.Mutable<UiState> {
    class Base : Communication.Post<UiState>(), CardsStateCommunication
}
interface CardsListCommunication : Communication.Mutable<List<CardUi>> {
    class Base : Communication.Post<List<CardUi>>(), CardsListCommunication
}