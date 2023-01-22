package com.example.binlist.detail.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.binlist.R
import com.example.binlist.main.presentation.BaseFragment

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardDetailFragment : BaseFragment<CardDetailViewModel.Base>() {
    override val layoutID = R.layout.fragment_detail_card
    override val viewModelClass = CardDetailViewModel.Base::class.java
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )
        val bin = view.findViewById<TextView>(R.id.titleBinTextView)
        val number = view.findViewById<TextView>(R.id.numberTextView)
        val scheme = view.findViewById<TextView>(R.id.schemeTextView)

        val mapper = ItemUiMapper(bin, number, scheme)
        viewModel.init(savedInstanceState == null)
        viewModel.observeCard(this) {
            it.map(mapper)
        }

    }
}