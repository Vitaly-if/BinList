package com.example.binlist.cards.data.cloud

import com.example.binlist.cards.data.BinCard
import com.example.binlist.cards.data.dto.CardDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardDetailCloudDataSource {
    suspend fun fetchCardDetail(): CardDTO

    abstract class Abstract(private val gson: Gson) : CardDetailCloudDataSource {
        override suspend fun fetchCardDetail(): CardDTO = gson.fromJson(
            getDataAsString(),
            object : TypeToken<CardDTO>() {}.type
        )
        protected abstract suspend fun getDataAsString(): String
    }
    class Base(
        private val service: CardDetailService,
        gson: Gson,
        private val bin: BinCard.Read
    ) : Abstract(gson) {
        override suspend fun getDataAsString(): String = service.fetchCardDetail("45717360").string()
    }


}