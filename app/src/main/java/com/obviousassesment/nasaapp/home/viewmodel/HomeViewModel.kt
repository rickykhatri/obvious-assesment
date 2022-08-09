package com.obviousassesment.nasaapp.home.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.obviousassesment.nasaapp.home.BaseViewModel
import com.obviousassesment.nasaapp.home.model.ImagesData
import com.obviousassesment.nasaapp.home.repository.ImageRepository

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val loadImagesData = MutableLiveData<ImagesData>()

    init {
        loadImagesData.postValue(ImageRepository.getJsonDataFromAsset())
    }
}