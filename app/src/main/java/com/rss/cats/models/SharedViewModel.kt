package com.rss.cats.models

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rss.cats.data.SimpleImageLoader
import com.rss.cats.data.SimpleImageSaver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    val imageLoader =
        SimpleImageLoader(application.applicationContext)

    val imageSaver =
        SimpleImageSaver(application.contentResolver)

    var selectedCat = MutableLiveData<Cat>()

    fun selectCat(cat: Cat) {
        selectedCat.postValue(cat)
    }

    fun saveCat(imageView: ImageView) {
        GlobalScope.launch {
            imageSaver.saveimage(imageView)
        }
    }
}
