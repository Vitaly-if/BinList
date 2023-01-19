package com.example.binlist.cards.sl

import com.example.binlist.cards.data.CardDTOToData
import com.example.binlist.cards.data.CardDataToCache
import com.example.binlist.cards.data.CardDetailRepository
import com.example.binlist.cards.data.cache.CardDetailCacheDataSource
import com.example.binlist.cards.data.cloud.CardDetailCloudDataSource
import com.example.binlist.cards.data.cloud.CardDetailService
import com.example.binlist.cards.domain.CardDataToDomain
import com.example.binlist.cards.domain.CardIterator
import com.example.binlist.cards.presentation.CardsViewModel
import com.example.binlist.main.sl.Core
import com.example.binlist.main.sl.Module

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardsModule(private val core: Core) : Module<CardsViewModel> {
    override fun viewModel(): CardsViewModel {
        val repository = ProvideNumbersRepository.Base(core).provideNumbersRepository()
        return CardsViewModel(CardIterator.Base(repository))
    }

}

interface ProvideNumbersRepository {

    fun provideNumbersRepository(): CardDetailRepository

    class Base(private val core: Core) : ProvideNumbersRepository {

        override fun provideNumbersRepository(): CardDetailRepository {
            val cacheDataSource = CardDetailCacheDataSource.Base(
                core.provideDataBase().cardsDao(),
                CardDataToCache()
            )
            return CardDetailRepository.Base(
                CardDetailCloudDataSource.Base(
                    core.service(CardDetailService::class.java),
                    core.provideGson(),
                    core.ProvideBinCard()
                ), cacheDataSource,
                CardDataToDomain(),
                CardDTOToData()
            )
        }
    }
}

