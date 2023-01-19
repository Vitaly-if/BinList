package com.example.binlist.detail.presentation

import com.example.binlist.R
import com.example.binlist.main.presentation.BaseFragment

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardDetailFragment: BaseFragment<CardDetailViewModel>() {
    override val layoutID = R.layout.fragment_detail_card
    override val viewModelClass = CardDetailViewModel::class.java
}