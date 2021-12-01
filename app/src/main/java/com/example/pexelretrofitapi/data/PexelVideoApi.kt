package com.example.pexelretrofitapi.data

import com.example.pexelretrofitapi.model.imagemodel.ImagePexel
import com.example.pexelretrofitapi.model.videomodel.VideoPexel
import com.example.pexelretrofitapi.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface PexelVideoApi {

    @Headers("Authorization: ${Constant.API_KEY}")
    @GET("/videos")
    suspend fun getAllVideo(): Response<VideoPexel>

}