package com.example.binlist.detail.presentation

import android.widget.TextView

class ItemUiMapper(
    private val binView: TextView,
    private val numberLength: TextView,
    private val numberLuhnView: TextView,
    private val schemeView: TextView,
    private val typeView: TextView,
    private val brandView: TextView,
    private val prepaidView: TextView,
    private val countryView: TextView,
    private val countryDetailView: TextView,
    private val bankNameView: TextView,
    private val bankUrlView: TextView,
    private val bankPhoneView: TextView,
) : CardDetailUi.Mapper<Unit> {
    override fun map(
        bin: String,
        number: CardNumberDetailUi,
        scheme: String,
        type: String,
        brand: String,
        prepaid: Boolean,
        country: CardCountryDetailUi,
        bank: CardBankDetailUi,
    ) {
        binView.text = bin
        numberLength.text = number.length
        numberLuhnView.text = number.luhn.toString()
        schemeView.text = scheme
        typeView.text = type
        brandView.text = brand
        prepaidView.text = prepaid.toString()
        countryView.text = "${country.alpha2} ${country.name}"
        countryDetailView.text = "(latitude: ${country.latitude}, longitude: ${country.longitude})"
        bankNameView.text = bank.name
        bankUrlView.text = bank.url
        bankPhoneView.text = bank.phone


    }
}