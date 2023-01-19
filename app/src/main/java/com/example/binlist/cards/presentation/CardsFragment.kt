package com.example.binlist.cards.presentation

import com.example.binlist.R
import com.example.binlist.main.presentation.BaseFragment

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardsFragment: BaseFragment<CardsViewModel>() {
    override val viewModelClass = CardsViewModel::class.java
    override val layoutID = R.layout.fragment_cards
}