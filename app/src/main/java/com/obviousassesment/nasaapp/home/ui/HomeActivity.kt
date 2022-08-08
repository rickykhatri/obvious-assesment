package com.obviousassesment.nasaapp.home.ui

import android.os.Bundle
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.obviousassesment.nasaapp.BR
import com.obviousassesment.nasaapp.R
import com.obviousassesment.nasaapp.databinding.ActivityHomeBinding
import com.obviousassesment.nasaapp.home.BaseActivity
import com.obviousassesment.nasaapp.home.model.ImagesData
import com.obviousassesment.nasaapp.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * This class shows images from json file in form of grid.
 */
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    private val  homeViewModel: HomeViewModel by viewModel()

    private val spanCount = 2

    override fun getLayoutId() = R.layout.activity_home

    override fun getViewModel() = homeViewModel

    override fun getBindingVariable() = BR.homeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
        observeImagesData()
    }

    private fun initView() {
        supportActionBar?.title = getString(R.string.home)
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
        val rvImagesData = findViewById<RecyclerView>(R.id.rvImagesData)
        rvImagesData?.apply {
            adapter = homeAdapter
        }
        rvImagesData?.layoutManager = GridLayoutManager(this,spanCount)
        homeAdapter.setData(imagesData)
    }
}