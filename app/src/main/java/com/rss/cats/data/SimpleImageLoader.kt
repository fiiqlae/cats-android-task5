package com.rss.cats.data

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide

class SimpleImageLoader(private val context: Context) : ImageLoader {

    override fun loadImage(imageView: ImageView, url: String) {
        Glide.with(context)
            .load(url)
            .placeholder(ColorDrawable(Color.GRAY))
            .into(imageView)
    }
}
