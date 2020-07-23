package com.rss.cats.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rss.cats.data.Api
import com.rss.cats.data.CatRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CatListViewModel: ViewModel() {

    private val repo: CatRepository = CatRepository(Api())
    private var currentPage: Int = 0
    var allCats = MutableLiveData<List<Cat>>()

    init {
        refresh()
    }

    private fun refresh() {
        GlobalScope.launch {
            allCats.postValue(repo.getCats(pageSize, currentPage) as List<Cat>?)
        }
    }

    fun loadNextPage() {
        currentPage += 1
        GlobalScope.launch {
            val currentCats:MutableList<Cat> = allCats.value as MutableList<Cat>
            val newCats = repo.getCats(pageSize, currentPage)
            allCats.postValue(listOf(currentCats, newCats).flatten() as List<Cat>?)
        }
    }
    private companion object {
        const val pageSize = 15
    }
}