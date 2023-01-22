package com.example.binlist.cards.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.binlist.R
import com.example.binlist.cards.domain.CardInteractor
import com.example.binlist.main.NavigationCommunication
import com.example.binlist.main.presentation.Init
import com.example.binlist.main.presentation.NavigationStrategy
import com.example.binlist.main.presentation.Screen
import kotlinx.coroutines.delay

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardsViewModel : Init, ClearError, ObserveCards, UpdateState, FetchCards {
    fun showDetail(card: CardUi)
    class Base(
        private val communications: CardsCommunication,
        private val manageResources: ManageResources,
        private val handleResult: HandleCardsRequest,
        private val navigationCommunication: NavigationCommunication.Mutate,
        private val interactor: CardInteractor.Base,
        private val mapperDetailUi: CardUi.Mapper<String>
    ) : ViewModel(), CardsViewModel {

        init {

        }

        override fun init(isFirstRun: Boolean) {
            if (isFirstRun)
                handleResult.handle(viewModelScope) {
                    interactor.init()
                }

        }

        override fun fetchCard(bin: String) {
            if (bin.isEmpty())
                communications.showState(UiState.ShowError(manageResources.string(R.string.empty_bin_error_message)))
            else {
                interactor.saveBinCard(bin)
                handleResult.handle(viewModelScope) {
                    interactor.fetchCard(bin)
                }
            }
//            viewModelScope.launch(Dispatchers.IO) {
//
//                iterator.fetchCard("45717360")
//                val cardinfo = iterator.cards()
//                withContext(Dispatchers.Main) {
//                    //card.value = cardinfo
//                    Log.i("vital", cardinfo.toString())
//                }
//            }

        }

        override fun showDetail(card: CardUi) {
            interactor.saveBinCard(card.map(mapperDetailUi))
            navigationCommunication.map(NavigationStrategy.Replace(Screen.Detail))

        }

        override fun clearError() {
            communications.showState(UiState.ClearError())
        }

        override fun observerProgress(owner: LifecycleOwner, observer: Observer<Int>) {
            communications.observerProgress(owner, observer)
        }

        override fun observerState(owner: LifecycleOwner, observer: Observer<UiState>) =
            communications.observerState(owner, observer)

        override fun observeList(owner: LifecycleOwner, observer: Observer<List<CardUi>>) {
            communications.observeList(owner, observer)
        }

        override fun updateState() {
            communications.showState(UiState.Success())
        }
    }
}

interface FetchCards {
    fun fetchCard(bin: String)
}

interface UpdateState {
    fun updateState()
}

interface ClearError {
    fun clearError()
}