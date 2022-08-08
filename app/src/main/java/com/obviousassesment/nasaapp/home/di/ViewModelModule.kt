package com.obviousassesment.nasaapp.home.di

import com.obviousassesment.nasaapp.home.viewmodel.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * ViewModel Module to inject all the ViewModels
 */
val viewModelModule = module {

    viewModel { HomeViewModel(androidApplication()) }
}
