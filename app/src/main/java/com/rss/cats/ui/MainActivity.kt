package com.rss.cats.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rss.cats.R
import com.rss.cats.models.CatViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var catViewModel: CatViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
