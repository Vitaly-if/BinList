package com.example.binlist.main.presentation

import com.example.binlist.cards.presentation.CardsFragment
import com.example.binlist.detail.presentation.CardDetailFragment

/**
 * @author Vitaly.N on 18.01.2023.
 */
sealed class Screen {
    abstract fun fragment(): Class<out BaseFragment<*>>

    object Cards : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = CardsFragment::class.java
    }

    object Detail : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = CardDetailFragment::class.java
    }
}