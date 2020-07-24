package com.rss.cats.di

import com.rss.cats.data.Api
import com.rss.cats.data.CatRepository
import com.rss.cats.data.Repository
import dagger.Module
import dagger.Provides

@Module
class NetworkingModule {
    @Provides
    fun provideRetrofitApi(): Api {
        return Api()
    }

    @Provides
    fun provideRepository(): Repository {
        return CatRepository(Api())
    }
}