package com.rss.cats.di

import com.rss.cats.data.Api
import dagger.Module
import dagger.Provides

@Module
class NetworkingModule {
    @Provides
    fun provideRetrofitApi(): Api {
        return Api()
    }
}