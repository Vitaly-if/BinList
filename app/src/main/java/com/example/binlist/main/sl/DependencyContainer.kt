package com.example.binlist.main.sl

import androidx.lifecycle.ViewModel
import com.example.binlist.cards.presentation.CardsViewModel
import com.example.binlist.cards.sl.CardsModule
import com.example.binlist.detail.presentation.CardDetailViewModel
import com.example.binlist.detail.sl.CardDetailModule
import com.example.binlist.main.presentation.MainViewModel
import java.lang.IllegalStateException

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface DependencyContainer {

    fun <T : ViewModel> module(clasz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clasz: Class<T>): Module<T> {
            throw IllegalStateException("no module found for $clasz")
        }

    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error(),
    ) : DependencyContainer {


        override fun <T : ViewModel> module(clasz: Class<T>): Module<*> = when (clasz) {
            MainViewModel::class.java -> MainModule(core)
            CardsViewModel.Base::class.java -> CardsModule(core)
            CardDetailViewModel.Base::class.java -> CardDetailModule(core)
            else -> dependencyContainer.module(clasz)
        }




    }
}