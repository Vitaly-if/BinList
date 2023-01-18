package com.example.binlist.cards.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Vitaly.N on 18.01.2023.
 */
@Database(entities = [CardCache::class], version = 1)
abstract class CardsDataBase : RoomDatabase() {
    abstract fun cardsDao() : CardsDao
}