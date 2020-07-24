package com.rss.cats.models

import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rss.cats.data.ImageLoader
import com.rss.cats.data.ImageSaver
import com.rss.cats.di.App
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel : ScopedViewModel() {

    private val _selectedCat = MutableLiveData<Cat>()
    val selectedCat: LiveData<Cat> get() = _selectedCat

    @Inject
    lateinit var imageSaver: ImageSaver

    @Inject
    lateinit var imageLoader: ImageLoader

    init {
        App.daggerComponent.inject(this)
    }

    fun selectCat(cat: Cat) {
        _selectedCat.postValue(cat)
    }

    fun loadImageIntoFrame(imageView: ImageView, cat: Cat) {
        imageLoader.loadImage(imageView, cat.url)
    }

    fun saveCat(imageView: ImageView) {
        scope.launch {
            imageSaver.saveImage(
                selectedCat.value?.let {
                    imageView.drawable.toBitmap(it.width, it.height)
                }
            )
        }
        Toast.makeText(imageView.context, "image saved", Toast.LENGTH_LONG).show()
    }
}