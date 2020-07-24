package com.rss.cats.di

import com.rss.cats.data.SimpleImageSaver
import com.rss.cats.models.CatViewModel
import com.rss.cats.models.SharedViewModel
import com.rss.cats.ui.CatListFragment
import com.rss.cats.ui.PreviewFragment
import dagger.Component

@Component(modules = [DataModule::class, NetworkingModule::class])
interface DaggerComponent {
    fun inject(model: CatViewModel)
    fun inject(model: SharedViewModel)
    fun inject(fragment: CatListFragment)
    fun inject(imageSaver: SimpleImageSaver)
    fun inject(fragment: PreviewFragment)

    @Component.Factory
    interface Factory {
        fun create(): DaggerComponent
    }
}