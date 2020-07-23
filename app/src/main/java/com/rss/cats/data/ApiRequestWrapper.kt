package com.rss.cats.data

import retrofit2.Response
import java.io.IOException

abstract class ApiRequestWrapper {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) return requireNotNull(response.body())
        else throw IOException(response.code().toString())
    }
}
