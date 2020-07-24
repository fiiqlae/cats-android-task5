package com.rss.cats.di

import android.content.Context
import com.rss.cats.data.*
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideRepository(): Repository = CatRepository()

    @Provides
    fun provideImageSaver(context: Context): ImageSaver = SimpleImageSaver(context.contentResolver)

    @Provides
    fun provideImageLoader(): ImageLoader = SimpleImageLoader()

    @Provides
    fun provideContext(): Context = App.context
}