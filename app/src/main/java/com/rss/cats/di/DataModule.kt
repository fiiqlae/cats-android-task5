package com.rss.cats.di

import com.rss.cats.data.*
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideRepository(): Repository = CatRepository()

    @Provides
    fun provideImageSaver(): ImageSaver = SimpleImageSaver()

    @Provides
    fun provideImageLoader(): ImageLoader = SimpleImageLoader()
}