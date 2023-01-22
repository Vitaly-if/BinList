package com.example.binlist.detail.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.detail.domain.CardDetailInteractor
import com.example.binlist.main.presentation.Init

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface CardDetailViewModel : Init, ObserveCardsDetail {
    class Base(
        private val communication: CardsDetailCommunication,
        private val handleResult: HandleCardDetailRequest,
        private val interactor: CardDetailInteractor.Base,
    ) : CardDetailViewModel, ViewModel() {

        override fun init(isFirstRun: Boolean) {
            handleResult.handle(viewModelScope) {
                interactor.fetchCardDetail()
            }
        }

        override fun observeCard(owner: LifecycleOwner, observer: Observer<CardDetailUi>) {
            communication.observeCard(owner, observer)
        }


    }
//                iterator.fetchCard("45717360")
//                val cardinfo = iterator.cards()
//                withContext(Dispatchers.Main) {
//                    //card.value = cardinfo
//                    Log.i("vital", cardinfo.toString())
//                }
//            }
}