package com.example.binlist.cards.sl

import com.example.binlist.cards.presentation.CardsViewModel
import com.example.binlist.main.sl.Core
import com.example.binlist.main.sl.Module

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardsModule(private val core: Core) : Module<CardsViewModel> {
    override fun viewModel(): CardsViewModel {
   return CardsViewModel(core.provideDataBase())
    }
}

