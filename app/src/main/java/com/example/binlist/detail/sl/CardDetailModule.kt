package com.example.binlist.detail.sl

import com.example.binlist.cards.sl.ProvideCardssRepository
import com.example.binlist.detail.domain.CardDetailInteractor
import com.example.binlist.detail.domain.CardDomainToUiDetailMapper
import com.example.binlist.detail.presentation.CardDetailCommunication
import com.example.binlist.detail.presentation.CardDetailViewModel
import com.example.binlist.detail.presentation.CardsDetailCommunication
import com.example.binlist.detail.presentation.HandleCardDetailRequest
import com.example.binlist.main.sl.Core
import com.example.binlist.main.sl.Module

/**
 * @author Vitaly.N on 19.01.2023.
 */
class CardDetailModule(private val core: Core) : Module<CardDetailViewModel.Base> {
    override fun viewModel(): CardDetailViewModel.Base {
        val communication = CardsDetailCommunication.Base(
            CardDetailCommunication.Base(),
        )
        val repository = ProvideCardssRepository.Base(core).provideCardsRepository()
        return CardDetailViewModel.Base(
            communication,
            HandleCardDetailRequest.Base(
                core.provideDispatcherList(),
                communication,
                CardDomainToUiDetailMapper()
            ),
            CardDetailInteractor.Base(repository, core.ProvideBinCard())
        )
    }
}