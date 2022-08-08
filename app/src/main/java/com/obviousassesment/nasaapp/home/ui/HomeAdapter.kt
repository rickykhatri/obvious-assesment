package com.obviousassesment.nasaapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.obviousassesment.nasaapp.R
import com.obviousassesment.nasaapp.databinding.ItemGridBinding
import com.obviousassesment.nasaapp.home.model.ImagesData

class HomeAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var imagesDataList: ImagesData? = null

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
                imagesDataList?.let {
                    binding.ivGrid.load(it[position].url) {
                        placeholder(R.drawable.placeholder)
                        error(R.drawable.placeholder)
                    }
                }
            }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ItemGridViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return imagesDataList?.size?:0
    }

    fun setData(imagesData: ImagesData) {
        imagesDataList = imagesData
        notifyDataSetChanged()
    }
}