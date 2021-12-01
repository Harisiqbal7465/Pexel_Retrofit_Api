package com.example.pexelretrofitapi.repository

import android.util.Log
import com.example.pexelretrofitapi.data.PexelImageApi
import com.example.pexelretrofitapi.data.PexelVideoApi
import com.example.pexelretrofitapi.model.imagemodel.Photo
import com.example.pexelretrofitapi.model.videomodel.Video
import com.example.pexelretrofitapi.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PexelImageVideoRepositoryImp @Inject constructor(
    private val api: PexelImageApi,
): PexelImageVideoRepository {
    override suspend fun getAllPexelImage(pageCount: Int, perPage: Int): Flow<Resource<List<Photo>>> = flow{
        try {
            emit(Resource.Loading<List<Photo>>())
            val api = api.getAllImage(pageCount = pageCount, perPage = perPage)
            Log.i("check","photos list api = ${api}")
            if(api.isSuccessful){
               api.body()?.let {
                   Log.i("check","photos list ${it.photos}")
                   emit(Resource.Success<List<Photo>>(it.photos))
               }
            } else {
                emit(Resource.Error<List<Photo>>(api.message()))
            }
        } catch (e: HttpException) {
            emit(Resource.Error<List<Photo>>(e.message ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Photo>>("Couldn't reach server. Check your internet connection"))
        }
    }

   /* override suspend fun getAllPexelVideo(): Flow<Resource<List<Video>>> = flow {
        try {
            emit(Resource.Loading<List<Video>>())
            val api = videApi.getAllVideo()
            if (api.isSuccessful) {
                api.body()?.let {
                    emit(Resource.Success<List<Video>>(it.videos))
                }
            }
        } catch (e: HttpException) {
            emit(Resource.Error<List<Video>>(e.message() ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Video>>("Couldn't reach server. Check your internet connection"))
        }
    }*/
}