package com.example.myapplication.di

import com.example.myapplication.data.service.ApiService
import com.example.myapplication.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl() = Constant.BASE_URL


    @Provides
    @Singleton
    fun providesRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}