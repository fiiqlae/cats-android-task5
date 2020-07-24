package com.rss.cats.di

import android.app.Application

class App : Application() {
    companion object {
        lateinit var daggerComponent: DaggerComponent
    }
    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        daggerComponent = DaggerDaggerComponent.builder().build()
    }
}