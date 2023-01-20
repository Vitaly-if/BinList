package com.example.binlist.cards.presentation

import android.view.View
import com.example.binlist.cards.domain.CardsResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @author Vitaly.N on 20.01.2023.
 */
interface HandleCardsRequest {

    fun handle(
        coroutineScope: CoroutineScope,
        block: suspend () -> CardsResult
    )

    class Base(
        private val dispatchers: DispatchersList,
        private val communications: CardsCommunication,
        private val cardsResultMapper: CardsResult.Mapper<Unit>,
    ) : HandleCardsRequest {

        override fun handle(
            coroutineScope: CoroutineScope,
            block: suspend () -> CardsResult
        ) {
            communications.showProgress(View.VISIBLE)
            coroutineScope.launch(dispatchers.io()) {
                val result = block.invoke()
                communications.showProgress(View.GONE)
                result.map(cardsResultMapper)
            }
        }
    }
}