package com.obviousassesment.nasaapp.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.obviousassesment.nasaapp.home.configurations.EnvironmentConfig

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val loadImagesData = MutableLiveData<String>()

    init {
        loadImagesData.postValue(EnvironmentConfig.getJsonDataFromAsset())
    }
}