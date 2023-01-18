package com.example.binlist.cards.data.cloud

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CloudModule {


    fun <T> service(clasz: Class<T>): T

    class Base() : CloudModule {

        override fun <T> service(clasz: Class<T>): T {

            val client = OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(clasz)
        }
    }

    private companion object {
        const val BASE_URL = "https://lookup.binlist.net/"
    }
}