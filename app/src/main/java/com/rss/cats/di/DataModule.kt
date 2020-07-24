package com.rss.cats.di

import com.rss.cats.data.ImageLoader
import com.rss.cats.data.ImageSaver
import com.rss.cats.data.SimpleImageLoader
import com.rss.cats.data.SimpleImageSaver
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun getImageSaver(): ImageSaver {
        return SimpleImageSaver()
    }

    @Provides
    fun provideImageLoader(): ImageLoader {
        return SimpleImageLoader()
    }
}