package com.example.binlist.cards.presentation

import com.example.binlist.cards.domain.CardDomain
import com.example.binlist.cards.domain.CardsResult

/**
 * @author Vitaly.N on 20.01.2023.
 */
class CardsResultMapper(
    private val communications: CardsCommunication,
    private val mapper: CardDomain.Mapper<CardUi>
) : CardsResult.Mapper<Unit> {

    override fun map(list: List<CardDomain>, errorMessage: String) = communications.showState(
        if (errorMessage.isEmpty()) {
            if (list.isNotEmpty())
                communications.showList(list.map { it.map(mapper) })
            UiState.Success()
        } else
            UiState.ShowError(errorMessage)
    )
}