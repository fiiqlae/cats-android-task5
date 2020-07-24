package com.rss.cats.data

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(imageView: ImageView, url: String)
}