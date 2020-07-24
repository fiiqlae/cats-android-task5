package com.rss.cats.models

import android.app.Application
import android.content.ContentResolver
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rss.cats.data.ImageLoader
import com.rss.cats.data.ImageSaver
import com.rss.cats.di.App
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    private val _selectedCat = MutableLiveData<Cat>()
    val selectedCat: LiveData<Cat> get() = _selectedCat
    private var resolver: ContentResolver? = null

    @Inject lateinit var imageLoader: ImageLoader
    @Inject lateinit var imageSaver: ImageSaver

    init {
        App.daggerComponent.inject(this)
        resolver = application.contentResolver
    }

    fun selectCat(cat: Cat) {
        _selectedCat.postValue(cat)
    }

    fun saveCat(imageView: ImageView) {
        GlobalScope.launch {
            resolver?.let { imageSaver.saveImage(imageView, it, requireNotNull(selectedCat.value)) }
        }
    }
}