package com.example.binlist.cards.presentation

import android.widget.TextView
import com.example.binlist.main.presentation.Mapper

/**
 * @author Vitaly.N on 20.01.2023.
 */
data class CardUi(private val bin: String, private val scheme: String) : Mapper<Boolean, CardUi> {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(bin, scheme)

    interface Mapper<T> {
        fun map(bin: String, scheme: String): T
    }

    override fun map(source: CardUi) = source.bin == bin

}
class DetailUi: CardUi.Mapper<String> {
    override fun map(bin: String, scheme: String): String {
        return bin
    }
}

class ListItemUi(
    private val binHead: TextView,
    private val schemeSubTitle: TextView
) : CardUi.Mapper<Unit> {

    override fun map(bin: String, scheme: String) {
        binHead.text = bin
        schemeSubTitle.text = scheme
    }
}
