package com.rss.cats.data

import com.rss.cats.models.Cat
import javax.inject.Inject

class CatRepository @Inject constructor() : ApiRequestWrapper(), Repository {
    private val api: Api = Api()
    override suspend fun getCats(pageSize: Int, page: Int): List<Cat> =
        apiRequest { api.getCats(pageSize, page) }
}