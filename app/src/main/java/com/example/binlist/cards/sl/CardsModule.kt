package com.example.binlist.cards.sl

import com.example.binlist.cards.data.CardDTOToData
import com.example.binlist.cards.data.CardDataToCache
import com.example.binlist.cards.data.CardDetailRepository
import com.example.binlist.cards.data.cache.CardDetailCacheDataSource
import com.example.binlist.cards.data.cloud.CardDetailCloudDataSource
import com.example.binlist.cards.data.cloud.CardDetailService
import com.example.binlist.cards.domain.*
import com.example.binlist.cards.presentation.*
import com.example.binlist.main.sl.Core
import com.example.binlist.main.sl.Module

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardsModule(private val core: Core) : Module<CardsViewModel.Base> {
    override fun viewModel(): CardsViewModel.Base {
        val repository = ProvideNumbersRepository.Base(core).provideNumbersRepository()
        val communication = CardsCommunication.Base(
            ProgressCommunication.Base(),
            CardsStateCommunication.Base(),
            CardsListCommunication.Base()
        )
        return CardsViewModel.Base(
            communication,
            core,
            HandleCardsRequest.Base(
                core.provideDispatcherList(),
                communication,
                CardsResultMapper(communication, CardDomainToUiMapper())

            ), core.provideNavigation(),


            CardInteractor.Base(
                repository,
                core.ProvideBinCard(),
                HandleRequest.Base(
                    HandleError.Base(core), repository)
            ))
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

