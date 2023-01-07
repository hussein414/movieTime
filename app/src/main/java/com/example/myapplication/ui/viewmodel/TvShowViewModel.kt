package com.example.myapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.TvShowsItem
import com.example.myapplication.data.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: TvShowRepository) : ViewModel() {
    private val _response = MutableLiveData<List<TvShowsItem>>()
    val responseTvShows: LiveData<List<TvShowsItem>> get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows()=viewModelScope.launch {
        repository.getTvShow().let {response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("ERO", "getAllTvShows Error:${response.code()} ")
            }
        }
    }
}