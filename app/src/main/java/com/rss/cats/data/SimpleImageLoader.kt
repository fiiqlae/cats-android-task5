package com.rss.cats.data

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide

class SimpleImageLoader : ImageLoader {

    override fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(ColorDrawable(Color.GRAY))
            .into(imageView)
    }
}