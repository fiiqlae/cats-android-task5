package com.rss.cats.di

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        lateinit var daggerComponent: DaggerComponent
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        initDagger()
        context = applicationContext
    }

    private fun initDagger() {
        daggerComponent = DaggerDaggerComponent.factory().create()
    }
}