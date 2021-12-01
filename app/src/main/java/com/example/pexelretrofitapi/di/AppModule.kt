package com.example.pexelretrofitapi.di

import com.example.pexelretrofitapi.data.PexelImageApi
import com.example.pexelretrofitapi.data.PexelVideoApi
import com.example.pexelretrofitapi.repository.PexelImageVideoRepository
import com.example.pexelretrofitapi.repository.PexelImageVideoRepositoryImp
import com.example.pexelretrofitapi.utils.Constant.IMAGE_BASE_URL
import com.example.pexelretrofitapi.utils.Constant.VIDEO_BASE_URL
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
    @Singleton
    fun provideImageRetrofitApiInstance(): PexelImageApi = Retrofit.Builder()
        .baseUrl(IMAGE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PexelImageApi::class.java)

    @Provides
    @Singleton
    fun providePexelImageRepository(api: PexelImageApi): PexelImageVideoRepository =
        PexelImageVideoRepositoryImp(api)

   /* @Provides
    @Singleton
    fun provideVideoRetrofitApiInstance(): PexelVideoApi {
        return Retrofit.Builder()
            .baseUrl(VIDEO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PexelVideoApi::class.java)
    }*/
}