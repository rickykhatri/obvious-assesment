package com.obviousassesment.nasaapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.obviousassesment.nasaapp.R
import com.obviousassesment.nasaapp.home.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel  = HomeViewModel(application)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        observeImagesData()
    }

    private fun observeImagesData() {
        homeViewModel.loadImagesData.observe(this) {
            if(!it.isNullOrEmpty()) {

            }
        }
    }
}