package com.example.binlist.cards.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.Card
import com.example.binlist.cards.data.CardDTOToData
import com.example.binlist.cards.data.CardDataToCache
import com.example.binlist.cards.data.CardDetailRepository
import com.example.binlist.cards.data.cache.CardDetailCacheDataSource
import com.example.binlist.cards.data.cloud.CardDetailCloudDataSource
import com.example.binlist.cards.data.cloud.CardDetailService
import com.example.binlist.cards.data.cloud.CloudModule
import com.example.binlist.cards.domain.CardDataToDomain
import com.example.binlist.cards.domain.CardIterator
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Vitaly.N on 17.01.2023.
 */
class CardsViewModel(private val iterator: CardIterator.Base) : ViewModel() {
    var card: MutableLiveData<Card> = MutableLiveData()

    init {

        getCard()
    }

    private fun getCard() {

        viewModelScope.launch(Dispatchers.IO) {

            iterator.fetchCard("45717360")
            val cardinfo = iterator.cards()
            withContext(Dispatchers.Main) {
                //card.value = cardinfo
                Log.i("vital", cardinfo.toString())
            }
        }
    }
}
