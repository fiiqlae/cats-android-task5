package com.rss.cats.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreviewViewModel: ViewModel() {
    private val cat: MutableLiveData<Cat> = MutableLiveData()

}