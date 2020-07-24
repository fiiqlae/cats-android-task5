package com.rss.cats.di

import com.rss.cats.models.CatViewModel
import com.rss.cats.models.SharedViewModel
import com.rss.cats.ui.CatListFragment
import dagger.Component

@Component(modules = [DataModule::class, NetworkingModule::class])
interface DaggerComponent {
/*
    fun getImageSaver(): ImageSaver
    fun getImageLoader(): ImageLoader
    fun getRepository(): Repository
    fun getRetrofitApi(): Api
*/

    fun inject(model: CatViewModel)
    fun inject(model: SharedViewModel)
    fun inject(model: CatListFragment)

    @Component.Factory
    interface Factory {
        fun create(): DaggerComponent
    }
}