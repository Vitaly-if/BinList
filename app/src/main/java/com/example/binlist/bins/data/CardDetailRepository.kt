package com.example.binlist.bins.data

import android.util.Log
import com.example.binlist.Card
import com.example.binlist.bins.data.cloud.CardDetailCloudDataSourse

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardDetailRepository {
    suspend fun fetchCardDetail(bin : String): Card
    class Base(private val cardDetailCloudDataSourse: CardDetailCloudDataSourse):
        CardDetailRepository {
        override suspend fun fetchCardDetail(bin: String): Card {
            val cardDTO = cardDetailCloudDataSourse.fetchCardDetail()
            Log.i("Vital", cardDTO.toString())
            return Card("Repository")
        }
    }
}