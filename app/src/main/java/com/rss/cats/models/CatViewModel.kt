package com.rss.cats.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rss.cats.data.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatViewModel @Inject constructor(private var repository: Repository) : ScopedViewModel() {

    private var currentPage: Int = 0
    private val _allCats: MutableLiveData<List<Cat>> = MutableLiveData()
    val allCats: LiveData<List<Cat>> get() = _allCats

    init {
        refresh()
    }

    private fun refresh() {
        scope.launch {
            _allCats.postValue(repository.getCats(pageSize, currentPage))
        }
    }

    fun loadNextPage() {
        currentPage += 1
        scope.launch {
            val currentCats: MutableList<Cat> = allCats.value as MutableList<Cat>
            val newCats = repository.getCats(pageSize, currentPage)
            _allCats.postValue(listOf(currentCats, newCats).flatten())
        }
    }

    private companion object {
        private const val pageSize = 15
    }
}