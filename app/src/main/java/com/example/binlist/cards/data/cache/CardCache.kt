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
    @PrimaryKey @ColumnInfo(name = "bin") var bin: String = "",
    @Embedded(prefix = "number_") var number: CardNumberCache = CardNumberCache(),
    var scheme: String = "",
    var type: String = "",
    var brand: String = "",
    var boolean: Boolean = false,
    @Embedded(prefix = "country_") var country: CardCountryCache = CardCountryCache(),
    @Embedded(prefix = "bank_") var bank: CardBankCache = CardBankCache(),
)
data class CardNumberCache(
    var length: String = "",
    var luhn: Boolean = false
)
data class CardCountryCache(
    var numeric: String = "",
    var alpha2: String = "",
    var name: String = "",
    var emoji: String = "",
    var currency: String = "",
    var latitude: Int = 0,
    var longitude: Int = 0,
)
data class CardBankCache(
    var name: String = "",
    var url: String = "",
    var phone: String = "",
    var city: String = "",
)

