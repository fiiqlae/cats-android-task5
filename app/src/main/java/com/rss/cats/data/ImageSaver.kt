package com.rss.cats.data

import android.graphics.Bitmap

interface ImageSaver {
    fun saveImage(bitmap: Bitmap?)
}