package com.example.binlist.main.presentation

import android.content.Context
import android.content.res.Resources
import androidx.annotation.StringRes

/**
 * @author Vitaly.N on 18.01.2023.
 */
interface ResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getResource(): Resources

    class Base(private val context: Context) : ResourceProvider {
        override fun getString(id: Int): String = context.getString(id)
        override fun getResource() = context.resources

    }
}