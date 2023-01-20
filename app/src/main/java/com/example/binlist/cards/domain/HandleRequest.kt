package com.example.binlist.cards.domain

import com.example.binlist.cards.data.CardDetailRepository
import com.example.binlist.cards.presentation.HandleError

/**
 * @author Vitaly.N on 20.01.2023.
 */
interface HandleRequest {

    suspend fun handle(block: suspend () -> Unit): CardsResult

    class Base(
        private val handleError: HandleError<String>,
        private val repository: CardDetailRepository
    ) : HandleRequest {

        override suspend fun handle(block: suspend () -> Unit) = try {
            block.invoke()
            CardsResult.Success(repository.allCards())
        } catch (e: Exception) {
            CardsResult.Failure(handleError.handle(e))
        }
    }
}