package com.example.film_screen.di

import com.example.film_screen.data.RetrofitServiceFilmInfo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal class NetworkModule {

    @Provides
    fun provideRetrofitServiceFilmInfo(retrofit: Retrofit): RetrofitServiceFilmInfo =
        retrofit.create(RetrofitServiceFilmInfo::class.java)
}