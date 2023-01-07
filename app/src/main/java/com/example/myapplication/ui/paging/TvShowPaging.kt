package com.example.myapplication.ui.paging

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.data.model.TvShowsItem

class TvShowPaging {
     val diffCallback = object : DiffUtil.ItemCallback<TvShowsItem>() {
        override fun areItemsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowsItem, newItem: TvShowsItem): Boolean {
            return newItem==oldItem
        }
    }
}