package com.example.binlist.cards.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.Card
import com.example.binlist.cards.data.CardDetailRepository
import com.example.binlist.cards.data.cloud.CardDetailCloudDataSource
import com.example.binlist.cards.data.cloud.CardDetailService
import com.example.binlist.cards.data.cloud.CloudModule
import com.example.binlist.cards.domain.CardIterator
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Vitaly.N on 17.01.2023.
 */
class CardDetailViewModel : ViewModel() {
    var card: MutableLiveData<Card> = MutableLiveData()

    private val cloudModule = CloudModule.Base()
    private var gson = Gson()


    init {

        getCard()
    }

    private fun getCard() {

        viewModelScope.launch(Dispatchers.IO) {
            val cardinfo =
                CardIterator.Base(CardDetailRepository.Base(CardDetailCloudDataSource.Base(
                    cloudModule.service(
                        CardDetailService::class.java),
                    gson,
                    "123"))).getCard()
            withContext(Dispatchers.Main) {
                card.value = cardinfo
                Log.i("vital", card.value.toString())
            }
        }
    }
}
