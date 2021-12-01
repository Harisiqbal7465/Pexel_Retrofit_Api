package com.example.pexelretrofitapi.data

import com.example.pexelretrofitapi.model.imagemodel.ImagePexel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PexelImageApi {

    @GET("curated")
    suspend fun getAllImage(
        @Header("Authorization") credentials: String= "563492ad6f91700001000001a4c672ce108348dd8214ad381f022f35" ,
        @Query("page") pageCount: Int,
        @Query("per_page") perPage: Int
    ): Response<ImagePexel>

}