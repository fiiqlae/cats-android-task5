package com.rss.cats.data

import com.rss.cats.models.Cat

interface Repository {
    suspend fun getCats(pageSize: Int, page: Int): List<Cat>
}