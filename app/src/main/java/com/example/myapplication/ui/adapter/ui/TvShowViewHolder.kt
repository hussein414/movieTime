package com.example.myapplication.ui.adapter.ui

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.data.model.TvShowsItem
import com.example.myapplication.databinding.TvShowItemBinding

class TvShowViewHolder(private val binding: TvShowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindData(model: TvShowsItem) {
        binding.apply {
            tvName.text = model.name
            tvLanguage.text = model.language
            tvImage.load(model.image.original){
                crossfade(true)
                crossfade(1000)

            }
        }
    }

}