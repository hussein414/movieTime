package com.example.myapplication.data.repository

import com.example.myapplication.data.service.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTvShow() = apiService.getTvShows()
}