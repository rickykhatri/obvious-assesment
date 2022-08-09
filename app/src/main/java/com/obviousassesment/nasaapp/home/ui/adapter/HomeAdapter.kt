package com.obviousassesment.nasaapp.home.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.obviousassesment.nasaapp.R
import com.obviousassesment.nasaapp.databinding.ItemGridBinding
import com.obviousassesment.nasaapp.home.Utils.AppUtils
import com.obviousassesment.nasaapp.home.model.ImagesData

class HomeAdapter(val imageClickListener: OnImageClickListener) : RecyclerView.Adapter<ViewHolder>() {

    private var imagesDataList: ImagesData? = null

    private val heightFactor = AppUtils.getScreenHeight() / 4
    private val widthFactor = AppUtils.getScreenWidth() / 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemGridBinding>(
            layoutInflater,
            R.layout.item_grid,
            parent,
            false
        )
        return  ItemGridViewHolder(binding)
    }

    inner class ItemGridViewHolder(private val binding: ItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int) {
                binding.ivGrid.layoutParams.height = heightFactor
                binding.ivGrid.layoutParams.width = widthFactor

                imagesDataList?.let {
                    binding.ivGrid.load(it[position].url) {
                        placeholder(R.drawable.placeholder)
                        error(R.drawable.placeholder)
                    }
                }
                binding.position = position
                binding.onItemClickListener = imageClickListener
                binding.executePendingBindings()
            }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ItemGridViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return imagesDataList?.size!!
    }

    fun setData(imagesData: ImagesData) {
        imagesDataList = imagesData
        notifyDataSetChanged()
    }

    interface OnImageClickListener {
        fun onImageClick(view: View, position: Int)
    }
}