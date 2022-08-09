package com.obviousassesment.nasaapp.home.ui.adapter

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.obviousassesment.nasaapp.home.model.ImagesData
import com.obviousassesment.nasaapp.home.model.ImagesDataItem
import com.obviousassesment.nasaapp.home.ui.ImageDetailFragmentView
import com.obviousassesment.nasaapp.home.ui.ImageDetailFragmentView.Companion.DESCRIPTION_KEY
import com.obviousassesment.nasaapp.home.ui.ImageDetailFragmentView.Companion.IMG_URL
import com.obviousassesment.nasaapp.home.ui.ImageDetailFragmentView.Companion.TITLE

/**
 * Adapter class for Viewpager
 */
internal class ImageDetailAdapter(
    fm: FragmentManager,
    private val context: Context,
    imagesData: ImagesData
) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var imagesDataList:ImagesData = imagesData

    override fun getCount(): Int = imagesDataList.size

    override fun getItem(position: Int): Fragment {
        val args = Bundle()
        args.putString(IMG_URL, imagesDataList[position].hdurl)
        args.putString(TITLE, imagesDataList[position].title)
        args.putString(DESCRIPTION_KEY, imagesDataList[position].explanation)
        return ImageDetailFragmentView.newInstance(args)
    }

    override fun saveState(): Parcelable? {
        return null
    }
}
