package com.example.binlist.cards.presentation

import com.example.binlist.R
import com.example.binlist.cards.domain.NoInternetConnectionException
import java.net.UnknownHostException

/**
 * @author Vitaly.N on 20.01.2023.
 */
interface HandleError<T> {

    fun handle(e: Exception): T

    class Base(private val manageResources: ManageResources) : HandleError<String> {

        override fun handle(e: Exception) = manageResources.string(
            when (e) {
                is UnknownHostException -> R.string.no_connection_message
                is retrofit2.HttpException -> R.string.card_not_found
                is NullPointerException -> R.string.error_processing_data
                else -> R.string.service_is_unavailable
            }
        )
    }
}