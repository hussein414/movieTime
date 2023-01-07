package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.model.TvShowsItem
import com.example.myapplication.databinding.TvShowItemBinding
import com.example.myapplication.ui.adapter.ui.TvShowViewHolder
import com.example.myapplication.ui.paging.TvShowPaging

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {
    private val differ by lazy {
        AsyncListDiffer(this, TvShowPaging().diffCallback)
    }

     var tvShows: List<TvShowsItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(
            TvShowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bindData(tvShows[position])
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }
}