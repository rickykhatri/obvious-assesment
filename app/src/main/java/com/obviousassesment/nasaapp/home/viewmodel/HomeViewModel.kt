package com.obviousassesment.nasaapp.home.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.obviousassesment.nasaapp.home.BaseViewModel
import com.obviousassesment.nasaapp.home.configurations.EnvironmentConfig
import com.obviousassesment.nasaapp.home.model.ImagesData

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val loadImagesData = MutableLiveData<ImagesData>()

    init {
        loadImagesData.postValue(EnvironmentConfig.getJsonDataFromAsset())
    }
}