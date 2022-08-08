package com.obviousassesment.nasaapp.home.ui

import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.obviousassesment.nasaapp.BR
import com.obviousassesment.nasaapp.R
import com.obviousassesment.nasaapp.databinding.ActivityHomeBinding
import com.obviousassesment.nasaapp.home.BaseActivity
import com.obviousassesment.nasaapp.home.model.ImagesData
import com.obviousassesment.nasaapp.home.viewmodel.HomeViewModel

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    private lateinit var  homeViewModel: HomeViewModel

    override fun getLayoutId() = R.layout.activity_home

    override fun getViewModel() = homeViewModel

    override fun getBindingVariable() = BR.homeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initializeView()
        observeImagesData()
    }

    private fun initializeView() {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    private fun observeImagesData() {
        homeViewModel.loadImagesData.observe(this) {
            if (!it.isNullOrEmpty()) {
                setAdapter(it)
            }
        }
    }

    /**
     * Sets data in recyclerView adapter
     */
    private fun setAdapter(imagesData: ImagesData) {
        val homeAdapter = HomeAdapter()
        getViewDataBinding()?.adapter = homeAdapter
        homeAdapter.setData(imagesData)
    }

}