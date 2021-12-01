package com.example.pexelretrofitapi.repository

import com.example.pexelretrofitapi.utils.Resource
import com.example.pexelretrofitapi.model.imagemodel.ImagePexel
import com.example.pexelretrofitapi.model.imagemodel.Photo
import com.example.pexelretrofitapi.model.videomodel.Video

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface PexelImageVideoRepository {
    suspend fun getAllPexelImage(pageCount: Int, perPage: Int): Flow<Resource<List<Photo>>>

//    suspend fun getAllPexelVideo(): Flow<Resource<List<Video>>>
}