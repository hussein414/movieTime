package com.example.myapplication.data.service

import com.example.myapplication.data.model.TvShowsResponse
import com.example.myapplication.utils.Constant
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constant.END_POINT)
    suspend fun getTvShows(): Response<TvShowsResponse>

}