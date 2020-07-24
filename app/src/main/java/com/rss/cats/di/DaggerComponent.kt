package com.rss.cats.di

import com.rss.cats.data.Api
import com.rss.cats.data.ImageLoader
import com.rss.cats.data.ImageSaver
import com.rss.cats.data.Repository
import com.rss.cats.models.CatViewModel
import com.rss.cats.models.SharedViewModel
import com.rss.cats.ui.CatAdapter
import dagger.Component

@Component(modules = [DataModule::class, NetworkingModule::class])
interface DaggerComponent {
    fun getImageSaver(): ImageSaver
    fun getImageLoader(): ImageLoader
    fun getRepository(): Repository
    fun getRetrofitApi(): Api

    fun inject(model: CatViewModel)
    fun inject(model: SharedViewModel)
    fun inject(adapter: CatAdapter)
}