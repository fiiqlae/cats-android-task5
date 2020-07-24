package com.rss.cats.data

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class SimpleImageLoader @Inject constructor() : ImageLoader {

    override fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(ColorDrawable(Color.GRAY))
            .into(imageView)
        Log.d("loading-image", url)
    }
}