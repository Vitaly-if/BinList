package com.example.binlist.cards.domain

/**
 * @author Vitaly.N on 20.01.2023.
 */
sealed class CardsResult {

    interface Mapper<T> {
        fun map(list: List<CardDomain>, errorMessage: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val list: List<CardDomain> = emptyList()) : CardsResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(list, "")
    }

    data class Failure(private val message: String) : CardsResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(emptyList(), message)
    }
}
