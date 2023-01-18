package com.example.binlist.cards.data.cloud

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Vitaly.N on 17.01.2023.
 */
interface CardDetailService {

    @GET("{bin}")
    suspend fun fetchCardDetail(@Path("bin") bin: String): ResponseBody
}