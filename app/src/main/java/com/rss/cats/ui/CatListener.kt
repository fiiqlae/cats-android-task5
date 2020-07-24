package com.rss.cats.ui

import com.rss.cats.models.Cat

interface CatListener {
    fun onDataSetExhausted()
    fun onPreview(cat: Cat)
}