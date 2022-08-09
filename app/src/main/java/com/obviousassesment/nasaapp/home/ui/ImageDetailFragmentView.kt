package com.obviousassesment.nasaapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.obviousassesment.nasaapp.R

/**
 * Fragment to populate ImageDetail view
 */
class ImageDetailFragmentView : Fragment() {

    companion object {

        const val IMG_URL = "url"
        const val TITLE ="title"
        const val DESCRIPTION_KEY = "description"

        fun newInstance(args: Bundle): ImageDetailFragmentView {
            val fragment = ImageDetailFragmentView()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_detail, container, false)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageResId = arguments?.getString(IMG_URL)
        val ivImageDetail = view.findViewById<ImageView>(R.id.ivImageDetail)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
        imageResId?.let { id ->
            ivImageDetail.load(id)
        }
        val title = arguments?.getString(TITLE)
        title?.let { imageTitle ->
            tvTitle.text = imageTitle
        }
        val description = arguments?.getString(DESCRIPTION_KEY)
        description?.let { imageDescription ->
            tvDescription.text = imageDescription
        }
    }
}