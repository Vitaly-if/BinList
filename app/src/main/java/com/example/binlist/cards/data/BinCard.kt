package com.example.binlist.cards.data

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface BinCard {
    interface Save {
        fun save(data: String)
    }

    interface Read {
        fun read(): String
    }

    interface Mutable : Save, Read

    class Base : Mutable {
        private var value = ""
        override fun save(data: String) {
            value = data
        }

        override fun read(): String = value
    }

}