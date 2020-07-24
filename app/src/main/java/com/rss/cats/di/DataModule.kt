package com.rss.cats.di

import com.rss.cats.data.*
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRetrofitApi(): Api {
        return Api()
    }

    @Provides
    fun provideRepository(): Repository {
        return CatRepository(Api())
    }

    @Provides
    fun getImageSaver(): ImageSaver {
        return SimpleImageSaver()
    }

    @Provides
    fun provideImageLoader(): ImageLoader {
        return SimpleImageLoader()
    }
}