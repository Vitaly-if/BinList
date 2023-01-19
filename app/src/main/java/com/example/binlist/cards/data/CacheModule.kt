package com.example.binlist.cards.data

import android.content.Context
import androidx.room.Room
import com.example.binlist.cards.data.cache.CardsDataBase

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface CacheModule {

    fun provideDataBase(): CardsDataBase

    class Base(private val context: Context) : CacheModule {

        private val database by lazy {
            return@lazy Room.databaseBuilder(
                context,
                CardsDataBase::class.java,
                "cards_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        override fun provideDataBase(): CardsDataBase = database
    }

    class Mock(private val context: Context) : CacheModule {
        private val database by lazy {
            Room.inMemoryDatabaseBuilder(context, CardsDataBase::class.java)
                .build()
        }

        override fun provideDataBase(): CardsDataBase = database
    }
}