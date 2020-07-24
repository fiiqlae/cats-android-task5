package com.rss.cats.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rss.cats.data.Repository
import com.rss.cats.di.App
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatViewModel : ViewModel() {

    private var currentPage: Int = 0
    private val _allCats: MutableLiveData<List<Cat>> = MutableLiveData()
    val allCats: LiveData<List<Cat>> get() = _allCats

    @Inject
    lateinit var repository: Repository

    init {
        App.daggerComponent.inject(this)
        refresh()
    }

    private fun refresh() {
        GlobalScope.launch {
            _allCats.postValue(repository.getCats(pageSize, currentPage))
        }
    }

    fun loadNextPage() {
        currentPage += 1
        GlobalScope.launch {
            val currentCats: MutableList<Cat> = allCats.value as MutableList<Cat>
            val newCats = repository.getCats(pageSize, currentPage)
            _allCats.postValue(listOf(currentCats, newCats).flatten())
        }
    }

    companion object {
        private const val pageSize = 15
    }
}