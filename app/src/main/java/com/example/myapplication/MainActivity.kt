package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.adapter.TvShowAdapter
import com.example.myapplication.ui.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val tvShowsViewModel: TvShowViewModel by viewModels()
    private lateinit var adapterTvShow: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()

    }

    private fun bindViews() {
        adapterTvShow = TvShowAdapter()
        tvShowsViewModel.responseTvShows.observe(this) { listTvShow ->
            adapterTvShow.tvShows = listTvShow
        }
        binding.tvShowRecyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2, RecyclerView.VERTICAL, false)
            adapter = adapterTvShow
        }
    }
}