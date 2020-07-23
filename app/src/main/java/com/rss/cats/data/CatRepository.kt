package com.rss.cats.data

class CatRepository(private val api: Api) : ApiRequest() {
    suspend fun getCats(pageSize: Int, page: Int): List<Any> = apiRequest { api.getCats(pageSize, page) }
}