package com.example.binlist.cards.data.cache

import androidx.room.*

/**
 * @author Vitaly.N on 18.01.2023.
 */
@Dao
interface CardsDao {
    @Query("SELECT * FROM cards_table")
    fun allCards(): List<CardCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: CardCache)

    @Query("SELECT * FROM cards_table WHERE bin = :bin")
    fun card(bin: String): CardCache?
}