package com.example.binlist.detail.sl

import com.example.binlist.detail.presentation.CardDetailViewModel
import com.example.binlist.main.sl.Module

/**
 * @author Vitaly.N on 19.01.2023.
 */
class CardDetailModule(): Module<CardDetailViewModel> {
    override fun viewModel(): CardDetailViewModel {
        return CardDetailViewModel()
    }
}