package com.rss.cats.models

import android.app.Application
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rss.cats.data.ImageLoader
import com.rss.cats.data.ImageSaver
import com.rss.cats.di.App
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    private val _selectedCat = MutableLiveData<Cat>()
    val selectedCat: LiveData<Cat> get() = _selectedCat
    private var app: Application? = null

    @Inject
    lateinit var imageLoader: ImageLoader
    @Inject
    lateinit var imageSaver: ImageSaver

    init {
        App.daggerComponent.inject(this)
        app = application
    }

    fun selectCat(cat: Cat) {
        _selectedCat.postValue(cat)
    }

    fun loadImageIntoFrame(imageView: ImageView, cat: Cat) {
        imageLoader.loadImage(imageView, cat.url)
    }

    fun saveCat(imageView: ImageView) {
        viewModelScope.launch {
            app?.contentResolver?.let {
                imageSaver.saveImage(
                    imageView,
                    it,
                    requireNotNull(selectedCat.value)
                )
            }
        }
        Toast.makeText(imageView.context, "image saved", Toast.LENGTH_SHORT).show()
    }
}