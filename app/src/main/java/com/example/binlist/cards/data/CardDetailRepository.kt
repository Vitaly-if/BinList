package com.example.binlist.cards.data

import android.util.Log
import com.example.binlist.Card
import com.example.binlist.cards.data.cloud.CardDetailCloudDataSource

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardDetailRepository {
    suspend fun fetchCardDetail(bin : String): Card
    class Base(private val cardDetailCloudDataSource: CardDetailCloudDataSource):
        CardDetailRepository {
        override suspend fun fetchCardDetail(bin: String): Card {
            val cardDTO = cardDetailCloudDataSource.fetchCardDetail()
            Log.i("Vital", cardDTO.toString())
            return Card("Repository")
        }
    }
}