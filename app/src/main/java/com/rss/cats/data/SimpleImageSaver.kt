package com.rss.cats.data

import android.content.ContentResolver
import android.graphics.Bitmap
import android.provider.MediaStore
import android.util.Log
import javax.inject.Inject

class SimpleImageSaver @Inject constructor(private var contentResolver: ContentResolver) :
    ImageSaver {

    override fun saveImage(bitmap: Bitmap?) {
        @Suppress("DEPRECATION")
        MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap,
            "${System.currentTimeMillis()}",
            ""
        )
        Log.d("saving", "${System.currentTimeMillis()}")
    }
}