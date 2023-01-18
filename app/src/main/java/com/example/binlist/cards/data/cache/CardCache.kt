package com.example.binlist.cards.data.cache

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Vitaly.N on 18.01.2023.
 */
@Entity(tableName = "cards_table")
data class CardCache(
    @PrimaryKey @ColumnInfo(name = "bin") val bin: String,
    @Embedded
    val number: CardNumberCache,
    val scheme: String,
    val type: String,
    val brand: String,
    val boolean: Boolean,
    @Embedded
    val country: CardCountryCache,
    @Embedded
    val bank: CardBankCache,
)
data class CardNumberCache(
    val length: String,
    val luhn: Boolean
)
data class CardCountryCache(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int,
)
data class CardBankCache(
    val name: String,
    val url: String,
    val phone: String,
    val city: String,
)

