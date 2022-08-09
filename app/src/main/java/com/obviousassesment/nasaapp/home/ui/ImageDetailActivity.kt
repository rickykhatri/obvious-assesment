package com.obviousassesment.nasaapp.home.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import com.obviousassesment.nasaapp.R
import com.obviousassesment.nasaapp.databinding.ActivityImageDetailBinding
import com.obviousassesment.nasaapp.home.BaseActivity
import com.obviousassesment.nasaapp.home.model.ImagesData
import com.obviousassesment.nasaapp.home.ui.adapter.ImageDetailAdapter
import com.obviousassesment.nasaapp.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Onboarding view for displaying waste management launching.
 */
class ImageDetailActivity : BaseActivity<ActivityImageDetailBinding, HomeViewModel>() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun getLayoutId() = R.layout.activity_image_detail

    override fun getViewModel() = homeViewModel

    override fun getBindingVariable() = BR.homeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewDataBinding()?.root?.visibility = View.GONE
        observeImagesData()
    }

    override fun onBackPressed() = if (getViewDataBinding()?.vpImageDetails?.currentItem == 0) {
        super.onBackPressed()
    } else {
        getViewDataBinding()?.vpImageDetails?.currentItem = getViewDataBinding()?.vpImageDetails?.currentItem!! - 1
    }

    override fun onResume() {
        super.onResume()
    }

    // Initialize View
    private fun initializeView(imagesData: ImagesData) {
        val pagerAdapter = ImageDetailAdapter(supportFragmentManager, this,imagesData)
        getViewDataBinding()?.vpImageDetails?.adapter = pagerAdapter
        getViewDataBinding()?.tabImageDetails?.setupWithViewPager(getViewDataBinding()?.vpImageDetails)
    }

    private fun observeImagesData() {
        homeViewModel.loadImagesData.observe(this) {
            if (!it.isNullOrEmpty()) {
                setUpNavigation(it)
            }
        }
    }

    // Setup click listeners
    private fun setUpClickListeners() {

    }

    /**
     * Method to navigate to particular as per conditions
     *
     * If User has logged in already :
     * [List] [ServiceAccount] > 0 My Services Page else No Service accounts page //TODO
     * If User is not logged in:
     * If Login Screen once seen navigate to it else to Onboarding
     */
    private fun setUpNavigation(imagesData: ImagesData) {
        getViewDataBinding()?.root?.visibility = View.VISIBLE
        initializeView(imagesData)
        setUpClickListeners()
    }
}