package com.rss.cats.data

import com.rss.cats.models.Cat
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("search")
    suspend fun getCats(
        @Query("limit") amount: Int,
        @Query("page") page: Int
    ): Response<List<Cat>>

    companion object {
        operator fun invoke(): Api {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.thecatapi.com/v1/images/")
                .build()
                .create(Api::class.java)
        }
    }
}