package com.example.binlist.detail.presentation

import android.widget.TextView

class ItemUiMapper(private val binView: TextView, private val numberView: TextView,
                   private val schemeView: TextView) : CardDetailUi.Mapper<Unit> {
    override fun map(
        bin: String,
        number: CardNumberDetailUi,
        scheme: String,
        type: String,
        brand: String,
        boolean: Boolean,
        country: CardCountryDetailUi,
        bank: CardBankDetailUi
    ) {
        binView.text = bin
        numberView.text = "Number: length ${number.length} luhn${number.luhn}"
        schemeView.text = scheme
    }
}