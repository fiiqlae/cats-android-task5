package com.rss.cats.data

import android.content.ContentResolver
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.rss.cats.models.Cat

class SimpleImageSaver : ImageSaver {
    override fun saveImage(imageView: ImageView, contentResolver: ContentResolver, cat: Cat) {
        @Suppress("DEPRECATION")
        MediaStore.Images.Media.insertImage(
            contentResolver,
            imageView.drawable.toBitmap(cat.width, cat.height),
            "${System.currentTimeMillis()}",
            ""
        )
    }
}