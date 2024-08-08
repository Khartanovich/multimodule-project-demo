package com.example.feature.di

import com.example.feature.data.RetrofitServicePremiers
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal class NetworkModule {

    @Provides
    fun provideRetrofitServicePremiers(retrofit: Retrofit): RetrofitServicePremiers =
        retrofit.create(RetrofitServicePremiers::class.java)
}