package com.example.binlist.main.sl

import android.content.Context
import com.example.binlist.cards.data.BinCard
import com.example.binlist.cards.data.CacheModule
import com.example.binlist.cards.data.cloud.CloudModule
import com.example.binlist.main.NavigationCommunication
import com.example.binlist.main.presentation.ResourceProvider
import com.google.gson.Gson

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface Core : CloudModule, CacheModule, ProvideNavigation, ProvideBinCard, ProvideResource,
ProvideGson{

    class Base(
        context: Context,
    ) : Core {
        private val cacheModule by lazy {
            CacheModule.Base(context)
        }
        private val navigationCommunication = NavigationCommunication.Base()
        private val resourceProvider = ResourceProvider.Base(context)
        private val binCard = BinCard.Base()
        private var gson = Gson()

        override fun <T> service(clasz: Class<T>): T = CloudModule.Base().service(clasz)

        override fun provideDataBase() = cacheModule.provideDataBase()

        override fun provideNavigation() = navigationCommunication

        override fun ProvideBinCard() = binCard

        override fun provideResource() = resourceProvider

        override fun provideGson() = gson

    }
}

interface ProvideNavigation {
    fun provideNavigation(): NavigationCommunication.Mutable
}

interface ProvideBinCard {
    fun ProvideBinCard(): BinCard.Mutable
}

interface ProvideResource {
    fun provideResource(): ResourceProvider
}

interface ProvideGson {
    fun provideGson(): Gson
}