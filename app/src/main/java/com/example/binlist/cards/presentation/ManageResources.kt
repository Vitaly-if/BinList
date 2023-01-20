package com.example.binlist.cards.presentation

import android.content.Context
import androidx.annotation.StringRes

/**
 * @author Vitaly.N on 20.01.2023.
 */
interface ManageResources {

    fun string(@StringRes id: Int): String

    class Base(private val context: Context) : ManageResources {
        override fun string(id: Int): String = context.getString(id)
    }
}