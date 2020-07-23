package com.rss.cats.data

import com.rss.cats.models.Cat

class CatRepository(private val api: Api) : ApiRequestWrapper() {
    suspend fun getCats(pageSize: Int, page: Int): List<Cat> =
        apiRequest { api.getCats(pageSize, page) }
}
