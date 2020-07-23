package com.rss.cats.data

import android.content.ContentResolver
import android.graphics.drawable.BitmapDrawable
import android.provider.MediaStore
import android.widget.ImageView

class SimpleImageSaver(private val contentResolver: ContentResolver) : ImageSaver {
    override fun saveimage(imageView: ImageView) {
        @Suppress("DEPRECATION")
        MediaStore.Images.Media.insertImage(
            contentResolver,
            (imageView.drawable as BitmapDrawable).bitmap,
            "${System.currentTimeMillis()}",
            ""
        )
    }
}
