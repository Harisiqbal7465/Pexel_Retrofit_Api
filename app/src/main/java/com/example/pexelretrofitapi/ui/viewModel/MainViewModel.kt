package com.example.pexelretrofitapi.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelretrofitapi.model.imagemodel.Photo
import com.example.pexelretrofitapi.model.videomodel.Video
import com.example.pexelretrofitapi.repository.PexelImageVideoRepository
import com.example.pexelretrofitapi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PexelImageVideoRepository
): ViewModel() {
    private val _getAllPhotos = MutableStateFlow<Resource<List<Photo>>>(Resource.Loading(null))
    val getAllPhotos : StateFlow<Resource<List<Photo>>> = _getAllPhotos

    private val _getAllVideos = MutableStateFlow<Resource<List<Video>>>(Resource.Loading())
    val getAllVideo: StateFlow<Resource<List<Video>>> = _getAllVideos


    fun getAllImages(pageCount: Int, perPage: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllPexelImage(pageCount, perPage).collect {
                _getAllPhotos.value = it
            }
        }
    }
    fun getAllVideo() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.getAllPexelVideo().collect {
//                _getAllVideos .value = it
//            }
//        }
    }
}