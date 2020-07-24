package com.rss.cats.data

import android.content.ContentResolver
import android.widget.ImageView
import com.rss.cats.models.Cat

interface ImageSaver {
    fun saveImage(imageView: ImageView, contentResolver: ContentResolver, cat: Cat)
}