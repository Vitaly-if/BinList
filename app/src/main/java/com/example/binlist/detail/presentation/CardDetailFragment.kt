package com.example.binlist.detail.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.binlist.R
import com.example.binlist.main.presentation.BaseFragment

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardDetailFragment : OpenResource, BaseFragment<CardDetailViewModel.Base>() {
    override val layoutID = R.layout.fragment_detail_card
    override val viewModelClass = CardDetailViewModel.Base::class.java
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )
        val bin = view.findViewById<TextView>(R.id.titleBinTextView)
        val numberLength = view.findViewById<TextView>(R.id.numberLengthTextView)
        val numberLuhn = view.findViewById<TextView>(R.id.numberLuhnTextView)
        val scheme = view.findViewById<TextView>(R.id.schemeTextView)
        val type = view.findViewById<TextView>(R.id.typeTextView)
        val brand = view.findViewById<TextView>(R.id.brandTextView)
        val prepaid = view.findViewById<TextView>(R.id.prepaidTextView)
        val country = view.findViewById<TextView>(R.id.countryTextView)
        val countryDetail = view.findViewById<TextView>(R.id.subcountryTextView)
        val bankName = view.findViewById<TextView>(R.id.bankNameTextView)
        val bankUrl = view.findViewById<TextView>(R.id.bankUrlTextView)
        val bankPhoneTextView = view.findViewById<TextView>(R.id.bankPhoneTextView)

        val mapper = ItemUiMapper(bin, numberLength, numberLuhn, scheme,
            type, brand, prepaid, country, countryDetail, bankName, bankUrl, bankPhoneTextView)
        viewModel.init(savedInstanceState == null)
        viewModel.observeCard(this) {
            it.map(mapper)
        }

        bankUrl?.setOnClickListener {
            openBrowser(bankUrl.text.toString())
        }
        bankPhoneTextView?.setOnClickListener {
            openPhone(bankPhoneTextView.text.toString())
        }
    }

    override fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http:$url"))
        startActivity(browserIntent)
    }

    override fun openPhone(phone: String) {
        val phoneIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel: $phone"))
        startActivity(phoneIntent)
    }
}

interface OpenResource {
    fun openBrowser(url: String)
    fun openPhone(phone: String)

}